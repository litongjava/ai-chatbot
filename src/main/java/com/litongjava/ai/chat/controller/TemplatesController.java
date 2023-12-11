package com.litongjava.ai.chat.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.http.server.util.Resps;

@RequestPath()
public class TemplatesController {
  private Engine engine = Aop.get(Engine.class);

  @RequestPath("/404")
  public Template notFound(HttpRequest request) {
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
