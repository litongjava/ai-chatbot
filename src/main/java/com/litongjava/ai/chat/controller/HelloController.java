package com.litongjava.ai.chat.controller;

import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.util.Resps;

public class HelloController {

  public HttpResponse hello(HttpRequest httprequest) {
    return Resps.txt(httprequest, "helo");
  }

  public HttpResponse hi(HttpRequest httprequest) {
    return Resps.txt(httprequest, "hi");
  }

}
