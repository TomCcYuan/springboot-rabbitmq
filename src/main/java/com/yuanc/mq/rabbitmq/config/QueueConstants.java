package com.yuanc.mq.rabbitmq.config;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description
 */
public interface QueueConstants {
    /**
     * 消息交换
     */
    String MESSAGE_EXCHANGE = "message.direct.exchange";
    /**
     * 消息队列名称
     */
    String MESSAGE_QUEUE_NAME = "message.queue";
    /**
     * 消息路由键
     */
    String MESSAGE_ROUTE_KEY = "message.send";
}
