package com.litongjava.ai.chat.config;

import com.litongjava.ai.chat.controller.HelloController;
import com.litongjava.annotation.AConfiguration;
import com.litongjava.annotation.Initialization;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.tio.boot.server.TioBootServer;
import com.litongjava.tio.http.server.router.HttpRequestRouter;

@AConfiguration
public class DefineHttpRoutesConfig {

  @Initialization
  public void httpRoutes() {
    HttpRequestRouter r = TioBootServer.me().getRequestRouter();
    HelloController helloController = Aop.get(HelloController.class);
    r.add("/hi", helloController::hi);
    r.add("/hello", helloController::hello);
  }
}
