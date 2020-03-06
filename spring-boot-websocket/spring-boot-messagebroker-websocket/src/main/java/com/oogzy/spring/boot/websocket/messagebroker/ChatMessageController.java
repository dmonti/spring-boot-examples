package com.oogzy.spring.boot.websocket.messagebroker;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.oogzy.spring.boot.websocket.messagebroker.dto.InboundMessage;
import com.oogzy.spring.boot.websocket.messagebroker.dto.OutboundMessage;

@Controller
public class ChatMessageController {
  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public OutboundMessage send(final InboundMessage message) throws Exception {
    final String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
    return new OutboundMessage(message.getFrom(), message.getText(), time);
  }
}
