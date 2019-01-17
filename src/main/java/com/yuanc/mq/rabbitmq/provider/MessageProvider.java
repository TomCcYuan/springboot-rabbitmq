package com.yuanc.mq.rabbitmq.provider;

import com.alibaba.fastjson.JSON;
import com.yuanc.mq.rabbitmq.config.QueueConstants;
import com.yuanc.mq.rabbitmq.config.RabbitMQConnectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description 消息队列 -- 消息生产者
 */
@Component
public class MessageProvider {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageProvider.class);
    /**
     * 消息队列模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Object object) {
        logger.info("写入消息队列内容:{}", JSON.toJSONString(object));
        CorrelationData correlation = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(QueueConstants.MESSAGE_EXCHANGE, QueueConstants.MESSAGE_ROUTE_KEY, object, correlation);
    }
}