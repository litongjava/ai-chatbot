package com.litongjava.ai.chat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.litongjava.annotation.RequestPath;

@RequestPath("/api/models")
public class ApiModelsController {

  @RequestPath
  public Map<String, Object> index(Boolean history_and_training_disabled) {
    Map<String, Object> map = new HashMap<>();
    List<Object> map_models = new ArrayList<>();
    Map<String, Object> map_models_item_0 = new HashMap<>();
    map_models_item_0.put("slug", "text-davinci-002-render-sha");
    map_models_item_0.put("max_tokens", 8191);
    map_models_item_0.put("title", "Default (GPT-3.5)");
    map_models_item_0.put("description", "Our fastest model, great for most everyday tasks.");
    List<Object> map_models_item_0_tags = new ArrayList<>();
    map_models_item_0_tags.add("gpt3.5");
    map_models_item_0.put("tags", map_models_item_0_tags);
    Map<String, Object> map_models_item_0_capabilities = new HashMap<>();
    map_models_item_0.put("capabilities", map_models_item_0_capabilities);
    Map<String, Object> map_models_item_0_product_features = new HashMap<>();
    map_models_item_0.put("product_features", map_models_item_0_product_features);
    map_models.add(map_models_item_0);
    Map<String, Object> map_models_item_1 = new HashMap<>();
    map_models_item_1.put("slug", "gpt-4");
    map_models_item_1.put("max_tokens", 32767);
    map_models_item_1.put("title", "GPT-4 (All Tools)");
    map_models_item_1.put("description", "Browsing, Advanced Data Analysis, and DALL E are now built into GPT-4");
    List<Object> map_models_item_1_tags = new ArrayList<>();
    map_models_item_1_tags.add("gpt4");
    map_models_item_1.put("tags", map_models_item_1_tags);
    Map<String, Object> map_models_item_1_capabilities = new HashMap<>();
    map_models_item_1.put("capabilities", map_models_item_1_capabilities);
    Map<String, Object> map_models_item_1_product_features = new HashMap<>();
    Map<String, Object> map_models_item_1_product_features_attachments = new HashMap<>();
    map_models_item_1_product_features_attachments.put("type", "retrieval");
    List<Object> map_models_item_1_product_features_attachments_accepted_mime_types = new ArrayList<>();
    map_models_item_1_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-java");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-typescript");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/javascript");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("application/x-latext");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/html");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-c");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("application/msword");
    map_models_item_1_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-tex");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-csharp");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-script.python");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-sh");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-php");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/plain");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/markdown");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-ruby");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("application/pdf");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("text/x-c++");
    map_models_item_1_product_features_attachments_accepted_mime_types.add("application/json");
    map_models_item_1_product_features_attachments.put("accepted_mime_types",
        map_models_item_1_product_features_attachments_accepted_mime_types);
    List<Object> map_models_item_1_product_features_attachments_image_mime_types = new ArrayList<>();
    map_models_item_1_product_features_attachments_image_mime_types.add("image/webp");
    map_models_item_1_product_features_attachments_image_mime_types.add("image/gif");
    map_models_item_1_product_features_attachments_image_mime_types.add("image/jpeg");
    map_models_item_1_product_features_attachments_image_mime_types.add("image/png");
    map_models_item_1_product_features_attachments.put("image_mime_types",
        map_models_item_1_product_features_attachments_image_mime_types);
    map_models_item_1_product_features_attachments.put("can_accept_all_mime_types", true);
    map_models_item_1_product_features.put("attachments", map_models_item_1_product_features_attachments);
    map_models_item_1.put("product_features", map_models_item_1_product_features);
    List<Object> map_models_item_1_enabled_tools = new ArrayList<>();
    map_models_item_1_enabled_tools.add("tools");
    map_models_item_1_enabled_tools.add("tools2");
    map_models_item_1.put("enabled_tools", map_models_item_1_enabled_tools);
    map_models.add(map_models_item_1);
    Map<String, Object> map_models_item_2 = new HashMap<>();
    map_models_item_2.put("slug", "gpt-4-plugins");
    map_models_item_2.put("max_tokens", 32767);
    map_models_item_2.put("title", "Plugins");
    map_models_item_2.put("description", "An experimental model that knows when and how to use plugins");
    List<Object> map_models_item_2_tags = new ArrayList<>();
    map_models_item_2_tags.add("beta");
    map_models_item_2_tags.add("gpt4");
    map_models_item_2.put("tags", map_models_item_2_tags);
    Map<String, Object> map_models_item_2_capabilities = new HashMap<>();
    map_models_item_2.put("capabilities", map_models_item_2_capabilities);
    Map<String, Object> map_models_item_2_product_features = new HashMap<>();
    map_models_item_2.put("product_features", map_models_item_2_product_features);
    List<Object> map_models_item_2_enabled_tools = new ArrayList<>();
    map_models_item_2_enabled_tools.add("tools3");
    map_models_item_2.put("enabled_tools", map_models_item_2_enabled_tools);
    map_models.add(map_models_item_2);
    Map<String, Object> map_models_item_3 = new HashMap<>();
    map_models_item_3.put("slug", "gpt-4-magic-create");
    map_models_item_3.put("max_tokens", 32767);
    map_models_item_3.put("title", "GPT Creator");
    map_models_item_3.put("description", "Browsing, Advanced Data Analysis, and DALL E are now built into GPT-4");
    List<Object> map_models_item_3_tags = new ArrayList<>();
    map_models_item_3_tags.add("plus");
    map_models_item_3_tags.add("hidden");
    map_models_item_3_tags.add("gpt4");
    map_models_item_3_tags.add("confidential");
    map_models_item_3.put("tags", map_models_item_3_tags);
    Map<String, Object> map_models_item_3_capabilities = new HashMap<>();
    map_models_item_3.put("capabilities", map_models_item_3_capabilities);
    Map<String, Object> map_models_item_3_product_features = new HashMap<>();
    Map<String, Object> map_models_item_3_product_features_attachments = new HashMap<>();
    map_models_item_3_product_features_attachments.put("type", "retrieval");
    List<Object> map_models_item_3_product_features_attachments_accepted_mime_types = new ArrayList<>();
    map_models_item_3_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-java");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-typescript");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/javascript");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("application/x-latext");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/html");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-c");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("application/msword");
    map_models_item_3_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-tex");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-csharp");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-script.python");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-sh");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-php");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/plain");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/markdown");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-ruby");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("application/pdf");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("text/x-c++");
    map_models_item_3_product_features_attachments_accepted_mime_types.add("application/json");
    map_models_item_3_product_features_attachments.put("accepted_mime_types",
        map_models_item_3_product_features_attachments_accepted_mime_types);
    List<Object> map_models_item_3_product_features_attachments_image_mime_types = new ArrayList<>();
    map_models_item_3_product_features_attachments_image_mime_types.add("image/webp");
    map_models_item_3_product_features_attachments_image_mime_types.add("image/gif");
    map_models_item_3_product_features_attachments_image_mime_types.add("image/jpeg");
    map_models_item_3_product_features_attachments_image_mime_types.add("image/png");
    map_models_item_3_product_features_attachments.put("image_mime_types",
        map_models_item_3_product_features_attachments_image_mime_types);
    map_models_item_3_product_features_attachments.put("can_accept_all_mime_types", true);
    map_models_item_3_product_features.put("attachments", map_models_item_3_product_features_attachments);
    map_models_item_3.put("product_features", map_models_item_3_product_features);
    List<Object> map_models_item_3_enabled_tools = new ArrayList<>();
    map_models_item_3_enabled_tools.add("tools");
    map_models_item_3_enabled_tools.add("tools2");
    map_models_item_3.put("enabled_tools", map_models_item_3_enabled_tools);
    map_models.add(map_models_item_3);
    Map<String, Object> map_models_item_4 = new HashMap<>();
    map_models_item_4.put("slug", "gpt-4-gizmo");
    map_models_item_4.put("max_tokens", 32767);
    map_models_item_4.put("title", "GPTs");
    map_models_item_4.put("description", "Browsing, Advanced Data Analysis, and DALL E are now built into GPT-4");
    List<Object> map_models_item_4_tags = new ArrayList<>();
    map_models_item_4_tags.add("plus");
    map_models_item_4_tags.add("hidden");
    map_models_item_4_tags.add("gpt4");
    map_models_item_4_tags.add("confidential");
    map_models_item_4.put("tags", map_models_item_4_tags);
    Map<String, Object> map_models_item_4_capabilities = new HashMap<>();
    map_models_item_4.put("capabilities", map_models_item_4_capabilities);
    Map<String, Object> map_models_item_4_product_features = new HashMap<>();
    Map<String, Object> map_models_item_4_product_features_attachments = new HashMap<>();
    map_models_item_4_product_features_attachments.put("type", "retrieval");
    List<Object> map_models_item_4_product_features_attachments_accepted_mime_types = new ArrayList<>();
    map_models_item_4_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-java");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-typescript");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/javascript");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("application/x-latext");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/html");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-c");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("application/msword");
    map_models_item_4_product_features_attachments_accepted_mime_types
        .add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-tex");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-csharp");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-script.python");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-sh");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-php");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/plain");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/markdown");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-ruby");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("application/pdf");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("text/x-c++");
    map_models_item_4_product_features_attachments_accepted_mime_types.add("application/json");
    map_models_item_4_product_features_attachments.put("accepted_mime_types",
        map_models_item_4_product_features_attachments_accepted_mime_types);
    List<Object> map_models_item_4_product_features_attachments_image_mime_types = new ArrayList<>();
    map_models_item_4_product_features_attachments_image_mime_types.add("image/webp");
    map_models_item_4_product_features_attachments_image_mime_types.add("image/gif");
    map_models_item_4_product_features_attachments_image_mime_types.add("image/jpeg");
    map_models_item_4_product_features_attachments_image_mime_types.add("image/png");
    map_models_item_4_product_features_attachments.put("image_mime_types",
        map_models_item_4_product_features_attachments_image_mime_types);
    map_models_item_4_product_features_attachments.put("can_accept_all_mime_types", true);
    map_models_item_4_product_features.put("attachments", map_models_item_4_product_features_attachments);
    map_models_item_4.put("product_features", map_models_item_4_product_features);
    List<Object> map_models_item_4_enabled_tools = new ArrayList<>();
    map_models_item_4_enabled_tools.add("tools");
    map_models_item_4_enabled_tools.add("tools2");
    map_models_item_4.put("enabled_tools", map_models_item_4_enabled_tools);
    map_models.add(map_models_item_4);
    map.put("models", map_models);
    List<Object> map_categories = new ArrayList<>();
    
    Map<String, Object> map_categories_item_0 = new HashMap<>();
    map_categories_item_0.put("category", "gpt_3.5");
    map_categories_item_0.put("human_category_name", "Qwen");
    map_categories_item_0.put("subscription_level", "free");
    map_categories_item_0.put("default_model", "text-davinci-002-render-sha");
    map_categories_item_0.put("code_interpreter_model", "text-davinci-002-render-sha-code-interpreter");
    map_categories_item_0.put("plugins_model", "text-davinci-002-render-sha-plugins");
    map_categories.add(map_categories_item_0);
    
    Map<String, Object> map_categories_item_1 = new HashMap<>();
    map_categories_item_1.put("category", "gpt_4");
    map_categories_item_1.put("human_category_name", "GPT-4");
    map_categories_item_1.put("subscription_level", "plus");
    map_categories_item_1.put("default_model", "gpt-4");
    map_categories_item_1.put("plugins_model", "gpt-4-plugins");
    map_categories.add(map_categories_item_1);
    map.put("categories", map_categories);

    return map;

  }
}