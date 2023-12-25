package com.litongjava.ai.chat;

import com.litongjava.hotswap.wrapper.tio.boot.TioApplicationWrapper;
import com.litongjava.jfinal.aop.annotation.ComponentScan;

@ComponentScan
public class BotApp {
  public static void main(String[] args) {
//    Diagnostic.setDebug(true);
    // HotSwapResolver.addHotSwapClassPrefix("com.litongjava.tio.http.server.");
    TioApplicationWrapper.run(BotApp.class, args);

  }
}
