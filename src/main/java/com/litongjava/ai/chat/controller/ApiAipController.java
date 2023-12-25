package com.litongjava.ai.chat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.litongjava.tio.http.server.annotation.RequestPath;

//@Controller
@RequestPath("/api/aip")
public class ApiAipController {

  @RequestPath("/p")
  public Map<String, Object> p(Integer offset, Integer limit, Boolean is_installed) {
    Map<String, Object> jsonMap = new HashMap<>();

    // 添加第一个元素
    Map<String, Object> item1 = new HashMap<>();

    item1.put("id", "plugin-014c6bf6-bc10-4762-abe5-8ba5f67005c9");
    item1.put("domain", "chatvideo.mixerbox.com");
    item1.put("namespace", "MixerBox_ChatVideo_YouTube_video_summarizer");
    item1.put("status", "approved");

    Map<String, Object> manifest1 = new HashMap<>();
    manifest1.put("schema_version", "v1");
    manifest1.put("name_for_model", "MixerBox_ChatVideo_YouTube_video_summarizer");
    manifest1.put("name_for_human", "MixerBox ChatVideo");
    manifest1.put("description_for_model",
        "MixerBox ChatVideo is an efficient tool for organizing various videos. It leverages transcripts, metadata, and other information from video providers such as YouTube to instantly summarize the key points of the videos. ...");
    manifest1.put("description_for_human", "Summarize videos from YouTube! Ask questions and get answers right away!");

    Map<String, Object> auth1 = new HashMap<>();
    auth1.put("type", "service_http");
    auth1.put("instructions", "");
    auth1.put("authorization_type", "bearer");

    Map<String, Object> verificationTokens1 = new HashMap<>();
    verificationTokens1.put("openai", "5e62144cda764f3ca70dbdeb9de9079e");
    auth1.put("verification_tokens", verificationTokens1);

    auth1.put("custom_auth_header", null);
    manifest1.put("auth", auth1);

    Map<String, Object> api1 = new HashMap<>();
    api1.put("type", "openapi");
    api1.put("url", "https://chatvideo.mixerbox.com/.well-known/openapi.json");
    manifest1.put("api", api1);

    manifest1.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/ChatVideo_logo.png");
    manifest1.put("contact_email", "support@chatvideo.mixerbox.com");
    manifest1.put("legal_info_url", "https://www.mixerbox.com");

    item1.put("manifest", manifest1);
    item1.put("oauth_client_id", null);
    Map<String, Object> userSettings1 = new HashMap<>();
    userSettings1.put("is_installed", true);
    userSettings1.put("is_authenticated", true);
    item1.put("user_settings", userSettings1);

    List<Map<String, Object>> categories1 = new ArrayList<>();
    Map<String, Object> category1 = new HashMap<>();
    category1.put("id", "newly_added");
    category1.put("title", "New");
    categories1.add(category1);
    item1.put("categories", categories1);

    item1.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/ChatVideo_logo.png");

    // 构建第二个元素 item2
    Map<String, Object> item2 = new HashMap<>();
    item2.put("id", "plugin-b4bd67b9-6acc-43d3-9a74-1d22dbef6d43");
    item2.put("domain", "translate.mixerbox.com");
    item2.put("namespace", "MixerBox_Translate_AI_language_tutor");
    item2.put("status", "approved");
    item2.put("oauth_client_id", null);

    Map<String, Object> userSettings2 = new HashMap<>();
    userSettings2.put("is_installed", true);
    userSettings2.put("is_authenticated", true);
    item2.put("user_settings", userSettings2);

    List<Map<String, Object>> categories2 = new ArrayList<>();
    Map<String, Object> category2 = new HashMap<>();
    category2.put("id", "newly_added");
    category2.put("title", "New");
    categories2.add(category2);
    item2.put("categories", categories2);

    item2.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/Translate_logo.png");

    Map<String, Object> manifest2 = new HashMap<>();
    manifest2.put("schema_version", "v1");
    manifest2.put("name_for_model", "MixerBox_Translate_AI_language_tutor");
    manifest2.put("name_for_human", "MixerBox Translate");
    manifest2.put("description_for_model",
        "MixerBox Translate is a versatile translation plugin that supports mutual translation and language learning between multiple languages. ...");
    manifest2.put("description_for_human",
        "Translate any language right away! Learn foreign languages easily by conversing with AI tutors!");

    Map<String, Object> auth2 = new HashMap<>();
    auth2.put("type", "none");
    manifest2.put("auth", auth2);

    Map<String, Object> api2 = new HashMap<>();
    api2.put("type", "openapi");
    api2.put("url", "https://translate.mixerbox.com/.well-known/openapi.json");
    manifest2.put("api", api2);

    manifest2.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/Translate_logo.png");
    manifest2.put("contact_email", "support@translate.mixerbox.com");
    manifest2.put("legal_info_url", "https://www.mixerbox.com");

    item2.put("manifest", manifest2);

    // 构建第三个元素 item3
    Map<String, Object> item3 = new HashMap<>();
    item3.put("id", "plugin-b7ad9a4a-2b08-40a9-8f77-e30a5ea4993c");
    item3.put("domain", "websearchg.mixerbox.com");
    item3.put("namespace", "MixerBox_WebSearchG_web_search");
    item3.put("status", "approved");
    item3.put("oauth_client_id", null);

    Map<String, Object> userSettings3 = new HashMap<>();
    userSettings3.put("is_installed", true);
    userSettings3.put("is_authenticated", true);
    item3.put("user_settings", userSettings3);

    List<Map<String, Object>> categories3 = new ArrayList<>();
    Map<String, Object> category3 = new HashMap<>();
    category3.put("id", "most_popular");
    category3.put("title", "Most popular");
    categories3.add(category3);
    item3.put("categories", categories3);

    item3.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/WebSearchG_logo.png");

    Map<String, Object> manifest3 = new HashMap<>();
    manifest3.put("schema_version", "v1");
    manifest3.put("name_for_model", "MixerBox_WebSearchG_web_search");
    manifest3.put("name_for_human", "MixerBox WebSearchG");
    manifest3.put("description_for_model",
        "MixerBox WebSearchG enables users to browse search engine results within the chat interface effortlessly. ...");
    manifest3.put("description_for_human",
        "Search and summarize the web with our customized search engine powered by Google Search API!");

    Map<String, Object> auth3 = new HashMap<>();
    auth3.put("type", "service_http");
    auth3.put("instructions", "");
    auth3.put("authorization_type", "bearer");

    Map<String, Object> verificationTokens3 = new HashMap<>();
    verificationTokens3.put("openai", "64c6984560ea4bf5ac266b96f88e688a");
    auth3.put("verification_tokens", verificationTokens3);

    auth3.put("custom_auth_header", null);
    manifest3.put("auth", auth3);

    Map<String, Object> api3 = new HashMap<>();
    api3.put("type", "openapi");
    api3.put("url", "https://websearchg.mixerbox.com/.well-known/openapi.json");
    manifest3.put("api", api3);

    manifest3.put("logo_url", "https://static.mixerbox.com/chatai/chatgpt-plugin/WebSearchG_logo.png");
    manifest3.put("contact_email", "support@websearchg.mixerbox.com");
    manifest3.put("legal_info_url", "https://websearchg.mixerbox.com");

    item3.put("manifest", manifest3);

    // 构建 items 数组
    List<Map<String, Object>> items = new ArrayList<>();
    items.add(item1);
    items.add(item2);
    items.add(item3);

    // 将 items 数组添加到 jsonMap
    jsonMap.put("items", items);

    // 添加 count
    jsonMap.put("count", 3);

    return jsonMap;
  }
}
