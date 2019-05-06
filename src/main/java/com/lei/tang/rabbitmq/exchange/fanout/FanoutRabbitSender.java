package com.lei.tang.rabbitmq.exchange.fanout;

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
public class FanoutRabbitSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String message) {
        //exchange：交换机的名称；routingKey：Fanout交换机无法使用routing_key，所以这里不设置routing_key；object：发送的数据
        rabbitTemplate.convertAndSend("fanoutExchange", "", message);
    }
}
