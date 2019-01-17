package com.yuanc.mq.rabbitmq.config;


import com.yuanc.mq.rabbitmq.RabbitMqFastJsonConverter;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description
 */
@Configuration
public class RabbitMqConfiguration {



    /**
     * 配置消息队列模版
     * 并且设置MessageConverter为自定义FastJson转换器
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        connectionFactory.addConnectionListener(new RabbitMQConnectionListener());
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new RabbitMqFastJsonConverter());
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        template.setConfirmCallback(new MsgSendConfirmCallBack());
        template.setReturnCallback(new MsgSendReturnCallback());

        return template;
    }

    /**
     * 自定义队列容器工厂
     * 并且设置MessageConverter为自定义FastJson转换器
     * @param connectionFactory
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new RabbitMqFastJsonConverter());
        factory.setDefaultRequeueRejected(false);
        factory.setMaxConcurrentConsumers(5);
        factory.setConcurrentConsumers(1);
        //每次处理5条消息
        factory.setPrefetchCount(5);
        //设置确认模式为手工确认
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }



}