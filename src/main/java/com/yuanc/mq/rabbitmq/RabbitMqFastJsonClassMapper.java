package com.yuanc.mq.rabbitmq;

import org.springframework.amqp.support.converter.DefaultClassMapper;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description
 */
public class RabbitMqFastJsonClassMapper extends DefaultClassMapper {
    /**
     * 构造函数初始化信任所有pakcage
     */
    public RabbitMqFastJsonClassMapper() {
        super();
        setTrustedPackages("*");
    }
}