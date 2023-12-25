package com.litongjava.ai.chat.config;

import com.litongjava.ai.chat.controller.HelloController;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.jfinal.aop.annotation.Bean;
import com.litongjava.jfinal.aop.annotation.BeforeStartConfiguration;
import com.litongjava.tio.http.server.handler.HttpRoutes;
import com.litongjava.tio.http.server.handler.SimpleHttpRoutes;

@BeforeStartConfiguration
public class DefineHttpRoutesConfig {

  @Bean
  public HttpRoutes httpRoutes() {
    HelloController helloController = Aop.get(HelloController.class);
    HttpRoutes simpleHttpRoutes = new SimpleHttpRoutes();
    simpleHttpRoutes.add("/hi", helloController::hi);
    simpleHttpRoutes.add("/hello", helloController::hello);
    return simpleHttpRoutes;
  }

}
