package com.lei.tang.rabbitmq.ordinary;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        //此处定义的队列名称，当此配置文件加载后此队列会加载至RabbitMQ客户端
        return new Queue("hello");
    }
}
