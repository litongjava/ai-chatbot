package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.tio.http.server.annotation.RequestPath;

@RequestPath("/api")
public class ApiConversationLimit {

  public Map<String,Object> conversation_limit(){
    Map<String,Object> message_disclaimer=new HashMap<>();
    message_disclaimer.put("textarea", "GPT-4 currently has a cap of 40 messages every 3 hours.");
    message_disclaimer.put("model-switcher", "You've reached the GPT-4 cap, which gives all ChatGPT Plus users a chance to try the model.\n\nPlease check back soon.");
    
    Map<String,Object> jsonMap=new HashMap<>();
    jsonMap.put("message_cap", 40.0);
    jsonMap.put("message_cap_window", 180.0);
    jsonMap.put("message_disclaimer", message_disclaimer);
    return jsonMap;
  }
}
