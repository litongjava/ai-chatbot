package com.litongjava.ai.chat.services;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.jfinal.kit.StrKit;
import com.litongjava.ai.chat.model.UserInfo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by litonglinux@qq.com on 12/14/2023_12:31 PM
 */
public class AuthService {

  private String buildId = "VkDNisWOezhjENf61sgQ1";
  // private String image="https://s.gravatar.com/avatar/e05cff43d0249c57f29fabb0f03cea85?s=480\\u0026r=pg\\u0026d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fli.png";
  private String image = "";

  // 使用HmacSHA256签名算法的密钥
  byte[] key = "litongjava".getBytes();
  // 用于存储tokens的Map
  // username,access_token
  private static Map<String, String> tokenStore = new HashMap<>();
  // access_token,username
  private static Map<String, String> userStore = new HashMap<>();

  public String auth0(String username, String password, String mfa_code) {
    // 载荷，可根据需要添加更多数据
    Map<String, Object> payload = new HashMap<>();
    payload.put("username", username);

    // 设置过期时间，例如1小时后
    long expirationMillis = System.currentTimeMillis() + 3600000; // 1小时 = 3600000毫秒
    Date expiration = new Date(expirationMillis);
    payload.put("exp", expiration.getTime() / 1000); // JWT通常使用秒为单位的时间戳

    // 生成JWT token
    String accessToken = JWTUtil.createToken(payload, key);
    // 将token存储到Map中
    tokenStore.put(username, accessToken);
    userStore.put(accessToken, username);
    return accessToken;
  }

  public boolean isValidToken(String token) {
    // 使用相同的密钥验证token
    return JWTUtil.verify(token, key);
  }

  public UserInfo getUserInfo(String accessToken) {
    if (StrKit.isBlank(accessToken)) {
      return null;
    }
    if (JWTUtil.verify(accessToken, key)) {
      String username = userStore.get(accessToken);
      if (username == null) {
        // 原因可能是服务器重启
        return null;
      }
      UserInfo userInfo = new UserInfo();
      // TO DO chage to from db
      userInfo.setUserId("user-1U8VuTtQxNVHSVw5tyO2Mtng");
      userInfo.setName(username);
      userInfo.setEmail(username);
      userInfo.setImage(image);
      userInfo.setPicture(image);
      userInfo.setGroups(new String[] {});

      return userInfo;
    }
    return null;
  }
  

  public JWTPayload getPayload(String value) {
    JWT jwt = JWTUtil.parseToken(value);
    JWTPayload payload = jwt.getPayload();
    return payload;
  }

  public void logout(String value) {
    String username = tokenStore.remove(value);
    userStore.remove(username);
  }

  public Map<String, Object> createProps(UserInfo userInfo, Map<String, Object[]> query, String remoteIp) {
    // 创建和填充 props
    Map<String, Object> root = new HashMap<>();

    // 填充用户信息
    Map<String, Object> user = new HashMap<>();
    user.put("id", userInfo.getUserId());
    user.put("name", userInfo.getEmail()); // 假设使用 email 作为 name
    user.put("email", userInfo.getEmail());
    user.put("image", userInfo.getImage());
    user.put("picture", userInfo.getPicture());
    user.put("groups", userInfo.getGroups());

    // 创建 serviceStatus 和 serviceAnnouncement，这里假设它们是空的 Map
    Map<String, Object> serviceStatus = new HashMap<>();
    Map<String, Object> serviceAnnouncement = new HashMap<>();
    serviceAnnouncement.put("paid", new HashMap<>());
    serviceAnnouncement.put("public", new HashMap<>());

    // 填充 pageProps
    Map<String, Object> pageProps = new HashMap<>();
    pageProps.put("user", user);
    pageProps.put("serviceStatus", serviceStatus);
    pageProps.put("userCountry", "US");
    // pageProps.put("geoOk", true);
    pageProps.put("serviceAnnouncement", serviceAnnouncement);
    pageProps.put("allowBrowserStorage", true);
    // pageProps.put("canManageBrowserStorage", false);
    pageProps.put("ageVerificationDeadline", "");
    // pageProps.put("isUserInCanPayGroup", true);
    pageProps.put("serverPrimedAllowBrowserStorageValue", true);
    pageProps.put("isStorageComplianceEnabled", false);
    pageProps.put("ageVerificationDeadline", "");
    pageProps.put("showCookieConsentBanner", false);
    pageProps.put("cfConnectingIp", remoteIp);

    // 将 pageProps 添加到 props
    root.put("props", pageProps);

    Map<String, Object> props = new HashMap<>();
    props.put("pageProps", pageProps);
    props.put("__N_SSP", true);

    // 其他属性
    root.put("page", "/[[...default]]");
    root.put("query", query);
    root.put("buildId", this.buildId);
    root.put("assetPrefix", "");
    root.put("isFallback", false);
    root.put("gssp", true);
    root.put("scriptLoader", new ArrayList<>());
    root.put("props", props);

    return root;
  }

}
