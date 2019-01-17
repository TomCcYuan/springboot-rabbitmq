package com.yuanc.mq.rabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.yuanc.mq.rabbitmq.config.QueueConstants;
import com.yuanc.mq.rabbitmq.entity.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description 消息队列 - 消息消费者
 */
@Component
@RabbitListener(queues = QueueConstants.MESSAGE_QUEUE_NAME)
public class MessageConsumer  {
    /**
     * logger instance
     */
    static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);



    @RabbitHandler
    public void handler(@Payload MessageEntity messageEntity,Message message,Channel channel) {
        logger.info("消费内容:{}", messageEntity.toString());
        //try {
        //    //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        //    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        //    System.out.println("receiver success");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    //丢弃这条消息
        //    //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
        //    System.out.println("receiver fail");
        //}
    }

}