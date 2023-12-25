package com.litongjava.ai.chat.controller;

import com.jfinal.template.Engine;
import com.litongjava.jfinal.aop.Aop;
import com.litongjava.jfinal.aop.annotation.Controller;
import com.litongjava.tio.http.server.annotation.RequestPath;

@Controller
@RequestPath("/aop")
public class AopController {

  // @RequestPath("/beans")
  public String[] beans() {
    return Aop.beans();
  }

  public String classloader() {
    return this.getClass().getClassLoader().toString();
  }

  public String getEngine() {
    Engine engine = Aop.get(Engine.class);
    return engine.toString();
  }

}
