package com.litongjava.ai.chat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.litongjava.tio.http.server.annotation.RequestPath;

@RequestPath("/api/prompt_library")
public class ApiPpromptLibrary {

  @RequestPath("/")
  public Map<String, Object> index(Integer limit, Integer offset) {
    Map<String, Object> map = new HashMap<>();
    List<Object> map_items = new ArrayList<>();
    Map<String, Object> map_items_item_0 = new HashMap<>();
    map_items_item_0.put("id", "9d9a6e9e");
    map_items_item_0.put("title", "Write a message");
    map_items_item_0.put("description", "that goes with a kitten gif for a friend on a rough day");
    map_items_item_0.put("prompt",
        "I want to cheer up my friend who's having a rough day. Can you suggest a couple short and sweet text messages to go with a kitten gif?");
    map_items.add(map_items_item_0);
    Map<String, Object> map_items_item_1 = new HashMap<>();
    map_items_item_1.put("id", "bbb177d3");
    map_items_item_1.put("title", "Compare marketing strategies");
    map_items_item_1.put("description", "for sunglasses for Gen Z and Millennials");
    map_items_item_1.put("prompt", "Compare Gen Z and Millennial marketing strategies for sunglasses.");
    map_items.add(map_items_item_1);
    Map<String, Object> map_items_item_2 = new HashMap<>();
    map_items_item_2.put("id", "7463dc89");
    map_items_item_2.put("title", "Create a content calendar");
    map_items_item_2.put("description", "for a TikTok account");
    map_items_item_2.put("prompt", "Create a content calendar for a TikTok account on reviewing real estate listings.");
    map_items.add(map_items_item_2);
    Map<String, Object> map_items_item_3 = new HashMap<>();
    map_items_item_3.put("id", "a1cf549a");
    map_items_item_3.put("title", "Suggest some names");
    map_items_item_3.put("description", "for my cafe-by-day, bar-by-night business");
    map_items_item_3.put("prompt",
        "Come up with 5 sophisticated names for my coffee shop that becomes a bar at night \u2013 like \"The Page Turner\". Include a short sentence explaining what it means!");
    map_items.add(map_items_item_3);
    map.put("items", map_items);
    map.put("total", 4);
    map.put("limit", 4);
    map.put("offset", 0);
    return map;
  }
}
