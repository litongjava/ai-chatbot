package com.litongjava.ai.chat.controller;

import com.litongjava.tio.core.Tio;
import com.litongjava.tio.http.common.HttpRequest;
import com.litongjava.tio.http.common.HttpResponse;
import com.litongjava.tio.http.server.annotation.RequestPath;
import com.litongjava.tio.http.server.sse.SsePacket;
import com.litongjava.tio.server.ServerChannelContext;

import lombok.extern.slf4j.Slf4j;

@RequestPath("/sse")
@Slf4j
public class SseController {

  @RequestPath
  public HttpResponse conversation(HttpRequest request, ServerChannelContext channelContext) {
    // 设置sse请求头
    HttpResponse httpResponse = new HttpResponse(request).setServerSentEventsHeader();
    // 手动发送消息到客户端,因为已经设置了sse的请求头,所以客户端的连接不会关闭
    Tio.send(channelContext, httpResponse);
    log.info("已经相应请求头");
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        String id = i + "";
        String eventName = "message";
        String data = "This is message " + i;
        SsePacket ssePacket = new SsePacket().eventId(id).name(eventName).data(data);
        // 再次向客户端发送消息
        Tio.send(channelContext, ssePacket);
        log.info("发送数据:{}", i);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      //手动移除连接
      Tio.remove(channelContext, "remove sse");
    }).start();

    // 告诉处理器不要将消息发送给客户端
    return new HttpResponse().setSend(false);

  }
}
