package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.StrKit;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.litongjava.ai.chat.model.UserInfo;
import com.litongjava.ai.chat.services.AuthService;
import com.litongjava.annotation.EnableCORS;
import com.litongjava.annotation.RequestPath;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.tio.http.common.Cookie;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;
import com.litongjava.tio.utils.json.JsonUtils;

@RequestPath("")
@EnableCORS
public class IndexController {
  Engine engine = Engine.use();

  @RequestPath("/")
  public HttpResponse index(HttpRequest request) {
    //String remoteIp = request.getRemote().getIp();
    String remoteIp = "127.0.0.1";

    Cookie cookie = request.getCookie("access-token");
    if (cookie == null) {
      return Resps.redirect(request, "/login");
    }
    AuthService authService = Aop.get(AuthService.class);
    UserInfo userInfo = authService.getUserInfo(cookie.getValue());
    if (userInfo == null) {
      return Resps.redirect(request, "/login");
    }
    Map<String, Object[]> query = request.getParams();

    String fileName = "chat.html";

    String string = getHtml(authService, userInfo, query, remoteIp, fileName);
    HttpResponse html = Resps.html(request, string);
    return html;
  }

  private String getHtml(AuthService authService, UserInfo userInfo, Map<String, Object[]> query, String remoteIp, String fileName) {
    // 构建 propsValue
    Map<String, Object> propsValue = authService.createProps(userInfo, query, remoteIp);
    Map<String, Object> viewData = new HashMap<>();
    // String
    // jsonString="{\"props\":{\"pageProps\":{\"user\":{\"id\":\"user-1U8VuTtQxNVHSVw5tyO2Mtng\",\"name\":\"litonglinux@gmail.com\",\"email\":\"litonglinux@gmail.com\",\"image\":\"https://s.gravatar.com/avatar/e05cff43d0249c57f29fabb0f03cea85?s=480\\u0026r=pg\\u0026d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fli.png\",\"picture\":\"https://s.gravatar.com/avatar/e05cff43d0249c57f29fabb0f03cea85?s=480\\u0026r=pg\\u0026d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fli.png\",\"idp\":\"auth0\",\"iat\":1702594920,\"mfa\":false,\"groups\":[],\"intercom_hash\":\"47bc2b0051e7029a116dd9a6122a32d014c8c4b3eeea11bd7e484fdceb7e2c65\"},\"serviceStatus\":{},\"userCountry\":\"US\",\"serviceAnnouncement\":{\"public\":{},\"paid\":{}},\"serverPrimedAllowBrowserStorageValue\":true,\"isStorageComplianceEnabled\":false,\"ageVerificationDeadline\":null,\"showCookieConsentBanner\":false,\"cfConnectingIp\":\"66.75.89.81\"},\"__N_SSP\":true},\"page\":\"/[[...default]]\",\"query\":{},\"buildId\":\"4cJ4pjOedeVdH2YA3VtTb\",\"assetPrefix\":\"https://cdn.oaistatic.com\",\"isFallback\":false,\"gssp\":true,\"scriptLoader\":[]}\r\n";
    String jsonString = JsonUtils.toJson(propsValue);
    //log.info("json string:{}", jsonString);
    viewData.put("props", jsonString);

    Template template = engine.getTemplate(fileName);
    String string = template.renderToString(viewData);
    return string;
  }

  @RequestPath("/c/{conversationId}")
  public HttpResponse detail(HttpRequest request, String type, String conversationId) {
    String remoteIp = "127.0.0.1";
    Cookie cookie = request.getCookie("access-token");
    if (cookie == null) {
      return Resps.redirect(request, "/login");
    }
    UserInfo userInfo = Aop.get(AuthService.class).getUserInfo(cookie.getValue());
    if (userInfo == null) {
      return Resps.redirect(request, "/login");
    }

    Map<String, Object[]> query = request.getParams();
    if (StrKit.notBlank(conversationId)) {
      query.put("default", new String[] { "c", conversationId });
    }
    AuthService authService = Aop.get(AuthService.class);
    String fileName = "detail.html";
    String string = getHtml(authService, userInfo, query, remoteIp, fileName);
    HttpResponse html = Resps.html(request, string);
    return html;
  }

  @RequestPath("/404")
  public Template notFound(HttpRequest request) {
    request.setAttribute("key", "value");

    String fileName = "/404.html";
    Template template = engine.getTemplate(fileName);
    return template;
  }

  @RequestPath("/chat")
  public HttpResponse chat(HttpRequest request) {
    String fileName = "/chat.html";
    return renderHtml(request, fileName);
  }

  @RequestPath("/detail")
  public HttpResponse detail(HttpRequest request) {
    String fileName = "/detail.html";
    return renderHtml(request, fileName);
  }

  @RequestPath("/login")
  public HttpResponse login(HttpRequest request) {
    String fileName = "/login.html";
    return renderHtml(request, fileName);
  }

  @RequestPath("/share")
  public HttpResponse share(HttpRequest request) {
    String fileName = "/share.html";
    return renderHtml(request, fileName);
  }

  private HttpResponse renderHtml(HttpRequest request, String fileName) {
    Template template = engine.getTemplate(fileName);
    String string = template.renderToString();
    HttpResponse html = Resps.html(request, string);
    return html;
  }
}
