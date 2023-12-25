package com.litongjava.ai.chat.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.JSON;
import com.litongjava.jfinal.aop.annotation.Controller;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.http.server.util.Resps;

@Controller
@RequestPath("/api/accounts")
@SuppressWarnings("serial")
public class ApiAccountsController {

  @RequestPath("/check/v4-2023-04-27")
  public HttpResponse check(HttpRequest request) {
    Map<String, Object> processorInfo = new HashMap<>();
    processorInfo.put("a001", new HashMap<String, Object>() {
      {
        put("has_customer_object", true);
      }
    });
    processorInfo.put("b001", new HashMap<String, Object>() {
      {
        put("has_transaction_history", false);
      }
    });
    processorInfo.put("c001", new HashMap<String, Object>() {
      {
        put("has_transaction_history", false);
      }
    });

    Map<String, Object> account = new HashMap<>();

    account.put("account_id", "a323bd05-db25-4e8f-9173-2f0c228cc8fa");
    account.put("account_user_id", "user-000000000000000000000000__a323bd05-db25-4e8f-9173-2f0c228cc8fa");
    account.put("account_user_role", "account-owner");
    account.put("has_previously_paid_subscription", true);
    account.put("is_most_recent_expired_subscription_gratis", false);
    account.put("name", null);
    account.put("organization_id", null);
    account.put("promo_data", new HashMap<>());
    account.put("structure", "personal");
    account.put("processor", processorInfo);

    HashMap<String, Object> last_active_subscription = new HashMap<String, Object>() {
      {
        put("subscription_id", "d0dcb1fc-56aa-4cd9-90ef-37f1e03576d3");
        put("purchase_origin_platform", "chatgpt_web");
        put("will_renew", true);
      }
    };

    HashMap<String, Object> entitlement = new HashMap<String, Object>() {
      {
        put("subscription_id", "d0dcb1fc-56aa-4cd9-90ef-37f1e03576d3");
        put("has_active_subscription", true);
        put("subscription_plan", "chatgptplusplan");
        put("expires_at", "2089-08-08T23:59:59+00:00");
      }
    };

    Map<String, Object> accountInfo = new HashMap<>();
    accountInfo.put("account", account);
    
    accountInfo.put("last_active_subscription", last_active_subscription);
    accountInfo.put("features", getFeatures());

    accountInfo.put("entitlement", entitlement);

    HashMap<String, Object> accounts = new HashMap<String, Object>();

    accounts.put("a323bd05-db25-4e8f-9173-2f0c228cc8fa", accountInfo);
    accounts.put("default", accountInfo);

    Map<String, Object> data = new HashMap<>();
    data.put("accounts", accounts);
    data.put("account_ordering", new String[] { "a323bd05-db25-4e8f-9173-2f0c228cc8fa" });

    return Resps.json(request, JSON.toJSONString(data));
  }

  public List<String> getFeatures() {
    List<String> features = Arrays.asList("priority_driven_models_list", "browsing_publisher_red_team",
        "plugin_review_tools", "message_debug_info", "user_latency_tools", "tools3_dev", "debug",
        "workspace_share_links", "retrieval_poll_ui", "sunshine_available", "use_stream_processor", "voice_available",
        "i18n", "model_switcher", "arkose_prefetch_ec", "persist_last_used_model", "code_interpreter_available",
        "breeze_available", "beta_features", "starter_prompts", "browsing_available", "new_plugin_oauth_endpoint",
        "dalle_3", "layout_may_2023", "shareable_links", "allow_url_thread_creation", "arkose_enabled",
        "invite_referral", "plugins_available", "ks", "chat_preferences_available", "model_switcher_upsell");
    return features;

  }
}
