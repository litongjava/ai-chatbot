package com.litongjava.ai.chat.validator;

import com.litongjava.model.body.RespBodyVo;

public class AuthValidator {

  public RespBodyVo loginValidate(String username, String password) {
    if ("litongjava@qq.com".equals(username) && "00000000".equals(password)) {
      return null;
    } else {
      return RespBodyVo.fail("Username or password is incorrect");
    }

  }

}
