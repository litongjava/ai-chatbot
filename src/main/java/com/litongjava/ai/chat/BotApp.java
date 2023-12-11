package com.litongjava.ai.chat;

import com.litongjava.jfinal.aop.annotation.ComponentScan;
import com.litongjava.tio.boot.TioApplication;

@ComponentScan
public class BotApp {
  public static void main(String[] args) {
    TioApplication.run(BotApp.class, args);
  }

}
