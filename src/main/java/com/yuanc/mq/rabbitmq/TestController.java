package com.yuanc.mq.rabbitmq;

import com.yuanc.mq.rabbitmq.entity.MessageEntity;
import com.yuanc.mq.rabbitmq.provider.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description
 */
@RestController
public class TestController {
    /**
     * 消息队列 - 消息提供者 注入
     */
    @Autowired
    private MessageProvider messageProvider;

    /**
     * 测试发送消息队列方法
     *
     * @param messageEntity 发送消息实体内容
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(MessageEntity messageEntity) {
        // 将实体实例写入消息队列
        messageProvider.sendMessage(messageEntity);
        return "Success";
    }
}