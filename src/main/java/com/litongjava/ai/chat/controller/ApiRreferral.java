package com.litongjava.ai.chat.controller;

import java.util.HashMap;
import java.util.Map;

import com.litongjava.tio.http.server.annotation.RequestPath;

@RequestPath("/api/referral")
public class ApiRreferral {
  public Map<String,Object> invites(){
    //{"status":"success","claimed_invites":0,"invites_remaining":0,"invite_codes":[]}
    Map<String,Object> jsonMap=new HashMap<>(1);
    jsonMap.put("statue", "success");
    jsonMap.put("claimed_invites", 0);
    jsonMap.put("invites_remaining", 0);
    jsonMap.put("invite_codes", new String[] {});
    return jsonMap;
  }

}
