package com.lei.tang.rabbitmq.ordinary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/5/6
 *
 * @RabbitListener(queues = "hello")接收消息的队列名称
 */
@Slf4j
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String messge) {
        log.info("===============HelloReceiver2 receiver message: {}", messge);
    }
}
