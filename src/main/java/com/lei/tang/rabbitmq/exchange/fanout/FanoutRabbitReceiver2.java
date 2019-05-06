package com.lei.tang.rabbitmq.exchange.fanout;

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
@RabbitListener(queues = "fanoutB")
public class FanoutRabbitReceiver2 {

    @RabbitHandler
    public void process(String message) {
        log.info("=========queue fanoutB receiver :{}", message);
    }
}
