package com.litongjava.ai.chat;

import com.litongjava.annotation.AComponentScan;
import com.litongjava.hotswap.wrapper.tio.boot.TioApplicationWrapper;

@AComponentScan
public class ChatBotApp {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
//    Diagnostic.setDebug(true);
    // HotSwapResolver.addHotSwapClassPrefix("com.litongjava.tio.http.server.");
    TioApplicationWrapper.run(ChatBotApp.class, args);
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");

  }
}
