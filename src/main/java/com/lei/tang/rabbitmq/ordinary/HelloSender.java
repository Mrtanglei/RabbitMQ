package com.lei.tang.rabbitmq.ordinary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/5/6
 * <p>
 * 发送者
 */
@Slf4j
@Component
public class HelloSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send(String messgae) {
        log.info("send message: {}", messgae);
        //定义的队列名称需在RabbitMQ服务器中存在，需与接收者一致
        amqpTemplate.convertAndSend("hello", messgae);
    }
}
