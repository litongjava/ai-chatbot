package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.StrKit;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.litongjava.ai.chat.services.AuthService;
import com.litongjava.ai.chat.validator.AuthValidator;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.jfinal.aop.annotation.Controller;
import com.litongjava.tio.http.common.Cookie;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.http.server.util.Resps;
import com.litongjava.tio.utils.resp.RespVo;

@Controller
@RequestPath("/auth")
public class AuthController {

  private AuthService authService = Aop.get(AuthService.class);
  private AuthValidator authValidator = Aop.get(AuthValidator.class);
  //private Engine engine = Aop.get(Engine.class);
  private Engine engine;
  //= Aop.get(Engine.class);

  @RequestPath("/login")
  public HttpResponse login(HttpRequest request, String next, String username, String password, String mfa_code,
      String action) {

    RespVo error = authValidator.loginValidate(username, password);
    if (error != null) {
      Template template = engine.getTemplate("login.html");
      Map<String, Object> viewData = new HashMap<>(1);
      viewData.put("error", error.getMsg());
      String string = template.renderToString(viewData);
      HttpResponse html = Resps.html(request, string);
      return html;
    }
    String err = null;
    if (StrKit.notBlank(username) && StrKit.notBlank(password)) {
      try {
        String accessToken = authService.auth0(username, password, mfa_code);
        HttpResponse response = Resps.redirect(request, "/");
        response.addCookie(new Cookie(null, "access-token", accessToken, null));
        return response;
      } catch (Exception e) {
        err = e.getMessage();
      }
    }
    return Resps.json(request, RespVo.fail(err));
  }
  
  @RequestPath("/logout")
  public HttpResponse logout(HttpRequest request) {
    Cookie cookie = request.getCookie("access-token");
    if(cookie!=null) {
      authService.logout(cookie.getValue());
    }
    HttpResponse response = Resps.redirect(request, "/login");
    response.addCookie(new Cookie(null, "access-token", "", null));
    return response;
    
  }

}
