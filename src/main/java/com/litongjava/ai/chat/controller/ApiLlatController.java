package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.annotation.RequestPath;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;

@RequestPath("/api/lat")
public class ApiLlatController {

  @RequestPath("/tti")
  public HttpResponse tti(HttpRequest reuqest) {
    // {"fcp_ms":206,"long_tasks_ms":15.5,"tti_ms":221.5}
    // String bodyString = reuqest.getBodyString();
    Map<String, Object> data = new HashMap<>(1);
    data.put("status", "success");
    return Resps.json(reuqest, data);
  }
}
