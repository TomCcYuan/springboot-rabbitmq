package com.yuanc.mq.rabbitmq.entity;

import java.io.Serializable;

/**
 * @author yuancheng
 * @Date 2018/6/15 0015
 * @Description
 */

public class MessageEntity implements Serializable {
    /**
     * 消息内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "content='" + content + '\'' +
                '}';
    }
}