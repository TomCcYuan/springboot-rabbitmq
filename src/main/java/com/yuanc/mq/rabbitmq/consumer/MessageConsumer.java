package com.yuanc.mq.rabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.yuanc.mq.rabbitmq.config.QueueConstants;
import com.yuanc.mq.rabbitmq.entity.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description 消息队列 - 消息消费者
 */
@Component
@RabbitListener(queues = QueueConstants.MESSAGE_QUEUE_NAME)
public class MessageConsumer {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitHandler
    public void handler(@Payload MessageEntity messageEntity) {
        logger.info("消费内容：{}", JSON.toJSONString(messageEntity));
    }
}