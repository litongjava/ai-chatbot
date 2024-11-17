package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.annotation.RequestPath;

@RequestPath("/api/settings")
public class ApiSettings {

  //@RequestPath("/beta_features")
  public Map<String, Object> beta_features() {
    //模拟返回数据
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("browsing", true);
    jsonMap.put("code_interpreter", true);
    jsonMap.put("plugins", true);
    jsonMap.put("sunshine", true);
    jsonMap.put("dalle", true);
    jsonMap.put("workspace_gpt_custom_actions", true);
    return jsonMap;
  }
}
