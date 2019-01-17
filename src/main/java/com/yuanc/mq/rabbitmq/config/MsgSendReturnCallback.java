package com.yuanc.mq.rabbitmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Arrays;

/**
 * @author yuancheng
 * @Date 2019/1/17 0017
 * @Description
 */
public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback {
    /**
     * Returned message callback.
     *
     * @param message    the returned message.
     * @param replyCode  the reply code.
     * @param replyText  the reply text.
     * @param exchange   the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息发送失败: " + Arrays.toString(message.getBody()));
    }
}
