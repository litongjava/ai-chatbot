package com.litongjava.ai.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
  private String userId;
  private String name;
  private String email;
  private String image;
  private String picture;
  //身份提供商
  private String idp = "auth0";
  //签发时间
  private String iat = "1702594920";
  //mfa
  private boolean mfa = false;
  private String intercom_hash;

  private String[] groups;

}