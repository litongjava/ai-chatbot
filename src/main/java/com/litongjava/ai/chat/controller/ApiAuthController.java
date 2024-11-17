package com.litongjava.ai.chat.controller;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.litongjava.ai.chat.model.UserInfo;
import com.litongjava.ai.chat.services.AuthService;
import com.litongjava.annotation.RequestPath;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.tio.http.common.Cookie;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;
import com.litongjava.tio.utils.jwt.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@RequestPath("/api/auth")
@Slf4j
public class ApiAuthController {

  private AuthService authService = Aop.get(AuthService.class);

  @RequestPath("/session")
  public HttpResponse session(HttpRequest reuqest) {
    Cookie cookie = reuqest.getCookie("access-token");
    if (cookie == null) {
      Resps.redirect(reuqest, "/login");
    }
    UserInfo userInfo = authService.getUserInfo(cookie.getValue());
    Map<String, Object> payload = JwtUtils.getPayload(cookie.getValue());

    Object claim = payload.get("exp");
    Long unixTimestamp = (Long) (claim);

    log.info("unixTimestamp:{}", claim);

    Instant instant = Instant.ofEpochSecond(unixTimestamp);
    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
    String isoDateTime = zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME);

    Map<String, Object> jsonMap = new HashMap<>(4);
    jsonMap.put("user", userInfo);
    jsonMap.put("expires", isoDateTime);
    jsonMap.put("accessToken", cookie.getValue());
    jsonMap.put("authProvider", "auth0");
    return Resps.json(reuqest, jsonMap);
  }

  @RequestPath("/csrf")
  public Map<String, Object> csrf() {
    Map<String, Object> data = new HashMap<>(1);
    data.put("csrfToken", "ca8a67e09fc1b14d5146184efeeeb7e42dd247e1772e1f728e6e802cbcfe414e");
    return data;
  }

  @RequestPath("/signout")
  public HttpResponse signout(HttpRequest request) {
    Cookie cookie = request.getCookie("access-token");
    if (cookie != null) {
      authService.logout(cookie.getValue());
    }
    Map<String, Object> data = new HashMap<>();
    data.put("url", "/login");
    HttpResponse response = Resps.json(request, data);
    response.addCookie(new Cookie(null, "access-token", "", null));
    return response;
  }
}
