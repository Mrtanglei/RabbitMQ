package com.lei.tang.rabbitmq.exchange.topic;

import com.lei.tang.rabbitmq.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.messages")
public class TopicRabbitReceiver2 {

    @RabbitHandler
    public void process(User user) {
        log.info("=========queue topic.messages receiver :{}", user.toString());
    }
}
