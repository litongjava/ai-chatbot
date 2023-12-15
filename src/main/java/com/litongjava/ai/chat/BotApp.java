package com.litongjava.ai.chat;

import com.litongjava.hotswap.wrapper.tio.boot.TioApplicationWrapper;
import com.litongjava.jfinal.aop.annotation.ComponentScan;
import com.litongjava.tio.utils.jfinal.P;

@ComponentScan
public class BotApp {
  public static void main(String[] args) {
    P.use("app.properties");
    //HotSwapResolver.addHotSwapClassPrefix("com.litongjava.jfinal");
    TioApplicationWrapper.run(BotApp.class, args);
//    TioApplication.run(BotApp.class, args);
  }
}
