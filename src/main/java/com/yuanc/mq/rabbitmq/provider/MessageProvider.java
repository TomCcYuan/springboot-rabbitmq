package com.yuanc.mq.rabbitmq.provider;

import com.alibaba.fastjson.JSON;
import com.yuanc.mq.rabbitmq.config.QueueConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object object) {
        logger.info("写入消息队列内容：{}", JSON.toJSONString(object));
        amqpTemplate.convertAndSend(QueueConstants.MESSAGE_EXCHANGE, QueueConstants.MESSAGE_ROUTE_KEY, object);
    }
}