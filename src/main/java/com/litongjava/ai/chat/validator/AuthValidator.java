package com.litongjava.ai.chat.validator;

import com.litongjava.tio.utils.resp.RespVo;

public class AuthValidator {

  public RespVo loginValidate(String username, String password) {
    if ("litongjava@qq.com".equals(username) && "00000000".equals(password)) {
      return null;
    } else {
      return RespVo.fail("Username or password is incorrect");
    }

  }

}
