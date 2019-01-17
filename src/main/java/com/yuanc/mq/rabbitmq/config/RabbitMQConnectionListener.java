package com.yuanc.mq.rabbitmq.config;

import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
/**
 * RabbitMQ服务器的连接状态
 *
 * @author yuancheng
 * @Date 2019/1/17 0017
 * @Description
 */
public class RabbitMQConnectionListener implements ConnectionListener {
    @Override
    public void onCreate(Connection connection) {
        System.out.println("服务器已启动...");
    }

    @Override
    public void onClose(Connection connection) {
        System.out.println("服务器已关闭...");

    }

}