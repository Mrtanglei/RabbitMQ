package com.lei.tang.rabbitmq.exchange.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue fanoutA(){
        return new Queue("fanoutA");
    }

    @Bean
    public Queue fanoutB(){
        return new Queue("fanoutB");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutExchangeA(FanoutExchange fanoutExchange,Queue fanoutA){
        //将队列fanoutA与fanoutExchange交换机进行绑定
        return BindingBuilder.bind(fanoutA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeB(FanoutExchange fanoutExchange,Queue fanoutB){
        //将队列fanoutB与fanoutExchange交换机进行绑定
        return BindingBuilder.bind(fanoutB).to(fanoutExchange);
    }
}
