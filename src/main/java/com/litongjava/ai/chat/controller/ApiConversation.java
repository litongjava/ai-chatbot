package com.litongjava.ai.chat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.litongjava.annotation.EnableCORS;
import com.litongjava.annotation.RequestPath;
import com.litongjava.tio.boot.http.TioRequestContext;
import com.litongjava.tio.core.Tio;
import com.litongjava.tio.http.common.HeaderName;
import com.litongjava.tio.http.common.HeaderValue;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.common.sse.SsePacket;
import com.litongjava.tio.server.ServerChannelContext;
import com.litongjava.tio.utils.json.FastJson2Utils;

import lombok.extern.slf4j.Slf4j;

@RequestPath("/backend-api/conversation")
@Slf4j
@EnableCORS
public class ApiConversation {

  @RequestPath
  public HttpResponse conversation(HttpRequest request, ServerChannelContext channelContext) {
    // 设置sse请求头
    HttpResponse httpResponse = TioRequestContext.getResponse();
    httpResponse.addServerSentEventsHeader();

    httpResponse.addHeader(HeaderName.Cache_Control, HeaderValue.from("no-cache"));
    httpResponse.addHeader(HeaderName.from("Cf-Cache-Status"), HeaderValue.from("DYNAMIC"));
    httpResponse.addHeader(HeaderName.from("Cf-Ray"), HeaderValue.from("83aeb780fa5a6a1a-HNL"));
    httpResponse.addHeader(HeaderName.from("Content-Security-Policy"), HeaderValue.from(
        "Content-Security-Policy:default-src 'self'; script-src 'self' 'nonce-pub1f79f8ac903a5872ae5f53026d20a77c' 'unsafe-inline' 'unsafe-eval' js.stripe.com https://chat.openai.com js.intercomcdn.com https://tcr9i.chat.openai.com https://oaistatic.com https://*.oaistatic.com https://chatgpt.com https://widget.intercom.io https://*.chatgpt.com; script-src-elem 'unsafe-inline' js.stripe.com https://chat.openai.com js.intercomcdn.com https://tcr9i.chat.openai.com challenges.cloudflare.com https://oaistatic.com https://*.oaistatic.com https://chatgpt.com auth0.openai.com https://widget.intercom.io https://*.chatgpt.com; img-src * 'self' data: https:; style-src 'self' 'unsafe-inline' https://chat.openai.com https://*.oaistatic.com https://chatgpt.com https://tcr9i.chat.openai.com https://*.chatgpt.com https://oaistatic.com; font-src 'self' data: https://*.oaistatic.com; connect-src 'self' statsigapi.net https://chat.openai.com wss://fp-async-webps-staging.webpubsub.azure.com *.oaiusercontent.com https://events.statsigapi.net api-js.mixpanel.com https://tcr9i.chat.openai.com fileserviceuploadsperm.blob.core.windows.net o33249.ingest.sentry.io wss://fp-async-webps-prod.webpubsub.azure.com https://featuregates.org https://oaistatic.com http://localhost:* https://*.oaistatic.com https://chatgpt.com api-iam.intercom.io https://*.chatgpt.com rum.browser-intake-datadoghq.com; frame-src tcr9i.chat.openai.com challenges.cloudflare.com js.stripe.com; worker-src blob:; report-uri https://csp-report.browser-intake-datadoghq.com/api/v2/logs?dd-api-key=pub1f79f8ac903a5872ae5f53026d20a77c&dd-evp-origin=content-security-policy&ddsource=csp-report;"));
    httpResponse.addHeader(HeaderName.from("Cross-Origin-Opener-Policy"), HeaderValue.from("same-origin"));
    httpResponse.addHeader(HeaderName.from("Nel"), HeaderValue.from("{\"success_fraction\":0.01,\"report_to\":\"cf-nel\",\"max_age\":604800}"));
    // Referrer-Policy:strict-origin-when-cross-origin
    httpResponse.addHeader(HeaderName.from("Referrer-Policy"), HeaderValue.from("strict-origin-when-cross-origin"));
    // Strict-Transport-Security:max-age=31536000; includeSubDomains; preload
    // Vary:Origin
    // X-Content-Type-Options:nosniff
    // X-Envoy-Upstream-Service-Time:440
    // X-Robots-Tag:nofollow
    httpResponse.addHeader(HeaderName.from("Strict-Transport-Security"), HeaderValue.from("max-age=31536000; includeSubDomains; preload"));
    httpResponse.addHeader(HeaderName.from("Vary"), HeaderValue.from("Origin"));
    httpResponse.addHeader(HeaderName.from("X-Content-Type-Options"), HeaderValue.from("nosniff"));
    httpResponse.addHeader(HeaderName.from("X-Envoy-Upstream-Service-Time"), HeaderValue.from("440"));
    httpResponse.addHeader(HeaderName.from("X-Robots-Tag"), HeaderValue.from("nofollow"));

    // 手动发送消息到客户端,因为已经设置了sse的请求头,所以客户端的连接不会关闭
    Tio.send(channelContext, httpResponse);
    // 解析json数据
    String bodyString = request.getBodyString();
    com.alibaba.fastjson2.JSONObject jsonObject = FastJson2Utils.parseObject(bodyString);

    String action = jsonObject.getString("action");
    String parentMessageId = jsonObject.getString("parent_message_id");
    String model = jsonObject.getString("model");
    JSONObject message = jsonObject.getJSONArray("messages").getJSONObject(0);

    // 第一次返回的消息
    double createTime = getCreateTime();
    Map<String, Object> firstMessage = getFirstMesage(action, parentMessageId, model, createTime, message);
    String conversationId = (String) firstMessage.get("conversation_id");
    String messageId = message.getString("id");
    Map<String, Object> secondMessage = getSecondMesage(conversationId, messageId, false);

    Map<String, Object> thirdMessage = getThirdMesage(action, parentMessageId, model, createTime, conversationId, message);
    Map<String, Object> fourthMessage = getFourthMesage(action, parentMessageId, model, createTime, conversationId, message);

    Map<String, Object> fifthMessage = getSecondMesage(conversationId, messageId, true);

    log.info("已经相应请求头");
    SsePacket firstMessagePacket = new SsePacket("message",JSON.toJSONString(firstMessage));
    // 再次向客户端发送消息
    Tio.send(channelContext, firstMessagePacket);
    log.info("发送数据:{}", "firstMessage");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    SsePacket secondMessagePacket = new SsePacket("message",JSON.toJSONString(secondMessage));

    Tio.send(channelContext, secondMessagePacket);
    log.info("发送数据:{}", "secondMessage");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    SsePacket thirdMessagePacket = new SsePacket("message",JSON.toJSONString(thirdMessage));
    Tio.send(channelContext, thirdMessagePacket);
    log.info("发送数据:{}", "thirdMessagePacket");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    SsePacket fourthMessagePacket = new SsePacket("message",JSON.toJSONString(fourthMessage));

    Tio.send(channelContext, fourthMessagePacket);
    log.info("发送数据:{}", "fourthMessagePacket");

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }

    SsePacket fifthMessagePacket = new SsePacket("message",JSON.toJSONString(fifthMessage));

    Tio.send(channelContext, fifthMessagePacket);
    log.info("发送数据:{}", "fifthMessagePacket");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Tio.remove(channelContext, "remove");

    // 告诉处理器不要将消息发送给客户端
    return new HttpResponse().setSend(false);

  }

  private Map<String, Object> getFourthMesage(String action, String parentMessageId, String model, double createTime, String conversationId, JSONObject message) {

    String this_message_id = message.getString("id");
    JSONObject messageMetadata = message.getJSONObject("metadata");
    String messageContentType = message.getJSONObject("content").getString("content_type");

    String part = "Who are you";

    Map<String, Object> map_message_author = new HashMap<>();
    map_message_author.put("role", "assistant");
    map_message_author.put("name", null);
    map_message_author.put("metadata", messageMetadata);

    Map<String, Object> map_message_content = new HashMap<>();
    map_message_content.put("content_type", messageContentType);
    List<Object> map_message_content_parts = new ArrayList<>();

    map_message_content_parts.add(part);
    map_message_content.put("parts", map_message_content_parts);

    List<Object> map_message_metadata_finish_details_stop_tokens = new ArrayList<>();
    map_message_metadata_finish_details_stop_tokens.add(100260);

    Map<String, Object> map_message_metadata_finish_details = new HashMap<>();
    map_message_metadata_finish_details.put("type", "stop");
    map_message_metadata_finish_details.put("stop_tokens", map_message_metadata_finish_details_stop_tokens);

    List<Object> map_message_metadata_citations = new ArrayList<>();
    Map<String, Object> map_message_metadata_citations_item_0 = new HashMap<>();
    map_message_metadata_citations_item_0.put("start_ix", 146);
    map_message_metadata_citations_item_0.put("end_ix", 157);
    map_message_metadata_citations_item_0.put("citation_format_type", "tether_og");
    Map<String, Object> map_message_metadata_citations_item_0_metadata = new HashMap<>();
    map_message_metadata_citations_item_0_metadata.put("type", "webpage");
    map_message_metadata_citations_item_0_metadata.put("title", "Docker \u90e8\u7f72 \u2013 PandoraNext");
    map_message_metadata_citations_item_0_metadata.put("url", "https://docs.pandoranext.com/zh-CN/deploy/docker#:~:text=,sessions");
    map_message_metadata_citations_item_0_metadata.put("text",
        "## \u76ee\u5f55\u7ed3\u6784\n\n\u4f60\u9700\u8981\u5728\u670d\u52a1\u5668\u4e0a\u521b\u5efa\u5982\u4e0b\u76ee\u5f55\u7ed3\u6784\u3002\u4f60\u53ef\u76f4\u63a5clone\u30103\u2020\u90e8\u7f72\u4ed3\u5e93 (opens in a new tab)\u2020github.com\u3011\uff0c\u5df2\u7ecf\u5907\u597d\u6587\u4ef6\u548c\u76ee\u5f55\u7ed3\u6784\uff1a\n\n\u901a\u5e38\u4f60\u4e0d\u9700\u8981\u53bb\u65b0\u5efa/\u4fee\u6539 `license.jwt `\u6587\u4ef6\uff0c\u53ef\u53c2\u8003\u301012\u2020license_id\u3011\u3002\n\n* pandoranext-deploy \n\n  * data \n    * config.json \n    * tokens.json \n    * license.jwt \n  * sessions");
    map_message_metadata_citations_item_0_metadata.put("pub_date", null);
    Map<String, Object> map_message_metadata_citations_item_0_metadata_extra = new HashMap<>();
    map_message_metadata_citations_item_0_metadata_extra.put("cited_message_idx", 50);
    map_message_metadata_citations_item_0_metadata_extra.put("evidence_text", "source");
    map_message_metadata_citations_item_0_metadata.put("extra", map_message_metadata_citations_item_0_metadata_extra);
    map_message_metadata_citations_item_0.put("metadata", map_message_metadata_citations_item_0_metadata);
    map_message_metadata_citations.add(map_message_metadata_citations_item_0);

    Map<String, Object> map_message_metadata = new HashMap<>();
    map_message_metadata.put("finish_details", map_message_metadata_finish_details);
    map_message_metadata.put("inline_gizmo_id", "g-CFsXuTRfy");
    map_message_metadata.put("citations", map_message_metadata_citations);
    map_message_metadata.put("is_complete", true);
    map_message_metadata.put("message_type", action);
    map_message_metadata.put("model_slug", model);
    map_message_metadata.put("parent_id", parentMessageId);

    Map<String, Object> map_message = new HashMap<>();
    map_message.put("id", this_message_id);
    map_message.put("author", map_message_author);
    map_message.put("create_time", createTime);
    map_message.put("update_time", null);
    map_message.put("content", map_message_content);
    map_message.put("status", "finished_successfully");
    map_message.put("end_turn", true);
    map_message.put("weight", 1.0);
    map_message.put("metadata", map_message_metadata);
    map_message.put("recipient", "all");

    Map<String, Object> map = new HashMap<>();
    map.put("message", map_message);
    map.put("conversation_id", conversationId);
    map.put("error", null);

    return map;
  }

  private Map<String, Object> getThirdMesage(String action, String parentMessageId, String model, double createTime, String conversationId, JSONObject message) {
    String this_message_id = message.getString("id");
    JSONObject messageMetadata = message.getJSONObject("metadata");
    String messageContentType = message.getJSONObject("content").getString("content_type");

    String part = "Yes,I am here";

    // map_message.put("id", "4a9fb037-2d99-4027-a252-80979954cea0");

    Map<String, Object> map_message_author = new HashMap<>();
    // map_message_author.put("role", "assistant");
    map_message_author.put("role", "role");
    map_message_author.put("name", "Unknown name");
    // Map<String, Object> map_message_author_metadata = new HashMap<>();
    map_message_author.put("metadata", messageMetadata);

    Map<String, Object> map_message_content = new HashMap<>();
    map_message_content.put("content_type", messageContentType);
    List<Object> map_message_content_parts = new ArrayList<>();
    map_message_content_parts.add(part);
    map_message_content.put("parts", map_message_content_parts);

    Map<String, Object> map_message_metadata = new HashMap<>();
    map_message_metadata.put("inline_gizmo_id", "g-CFsXuTRfy");
    map_message_metadata.put("message_type", action);
    map_message_metadata.put("model_slug", model);
    map_message_metadata.put("parent_id", parentMessageId);

    Map<String, Object> map_message = new HashMap<>();
    map_message.put("id", this_message_id);
    map_message.put("author", map_message_author);
    // map_message.put("create_time", 1703325153.78043);
    map_message.put("create_time", createTime);
    map_message.put("update_time", null);
    map_message.put("content", map_message_content);
    map_message.put("status", "in_progress");
    map_message.put("end_turn", null);
    map_message.put("weight", 1.0);
    map_message.put("metadata", map_message_metadata);
    map_message.put("recipient", "all");

    Map<String, Object> map = new HashMap<>();
    map.put("message", map_message);
    // map.put("conversation_id", "12f45214-6887-4ed4-af96-db7ba34e042e");
    map.put("conversation_id", conversationId);
    map.put("error", null);
    return map;
  }

  private Map<String, Object> getSecondMesage(String conversationId, String messageId, boolean isCompletion) {
    Map<String, Object> map_moderation_response = new HashMap<>();
    map_moderation_response.put("flagged", false);
    map_moderation_response.put("blocked", false);
    map_moderation_response.put("moderation_id", "modr-8YsyHo4rjKAQR7PJ2y5ekgMmYbmge");

    Map<String, Object> map = new HashMap<>();
    map.put("conversation_id", conversationId);
    map.put("message_id", messageId);
    map.put("is_completion", isCompletion);
    map.put("moderation_response", map_moderation_response);
    return map;
  }

  private Map<String, Object> getFirstMesage(String action, String parentMessageId, String model, double createTime, JSONObject message) {
    String this_message_id = message.getString("id");
    JSONObject messageMetadata = message.getJSONObject("metadata");
    String messageContentType = message.getJSONObject("content").getString("content_type");

    // map_message.put("id", "4a9fb037-2d99-4027-a252-80979954cea0");

    Map<String, Object> map_message_author = new HashMap<>();
    // map_message_author.put("role", "assistant");
    map_message_author.put("role", "role");
    map_message_author.put("name", "Unknown name");
    // Map<String, Object> map_message_author_metadata = new HashMap<>();
    map_message_author.put("metadata", messageMetadata);

    Map<String, Object> map_message_content = new HashMap<>();
    map_message_content.put("content_type", messageContentType);
    List<Object> map_message_content_parts = new ArrayList<>();
    map_message_content_parts.add("");
    map_message_content.put("parts", map_message_content_parts);

    Map<String, Object> map_message_metadata = new HashMap<>();
    map_message_metadata.put("inline_gizmo_id", "g-CFsXuTRfy");
    map_message_metadata.put("message_type", action);
    map_message_metadata.put("model_slug", model);
    map_message_metadata.put("parent_id", parentMessageId);

    Map<String, Object> map_message = new HashMap<>();
    map_message.put("id", this_message_id);
    map_message.put("author", map_message_author);
    // map_message.put("create_time", 1703325153.78043);
    map_message.put("create_time", createTime);
    map_message.put("update_time", null);
    map_message.put("content", map_message_content);
    map_message.put("status", "in_progress");
    map_message.put("end_turn", null);
    map_message.put("weight", 1.0);
    map_message.put("metadata", map_message_metadata);
    map_message.put("recipient", "all");

    String uuidString = UUID.randomUUID().toString();
    Map<String, Object> map = new HashMap<>();
    map.put("message", map_message);
    // map.put("conversation_id", "12f45214-6887-4ed4-af96-db7ba34e042e");
    map.put("conversation_id", uuidString);
    map.put("error", null);
    return map;
  }

  private double getCreateTime() {
    return System.currentTimeMillis() / 1000;
  }
}
