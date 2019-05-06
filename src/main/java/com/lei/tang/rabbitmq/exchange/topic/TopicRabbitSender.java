package com.lei.tang.rabbitmq.exchange.topic;

import com.lei.tang.rabbitmq.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@Slf4j
@Component
public class TopicRabbitSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send1(User user){
        //exchange：交换机的名称；routingKey：routing_key；object：发送的数据
        rabbitTemplate.convertAndSend("exchange", "topic.message",user);
    }

    public void send2(User user){
        rabbitTemplate.convertAndSend("exchange", "topic.messages",user);
    }
}
