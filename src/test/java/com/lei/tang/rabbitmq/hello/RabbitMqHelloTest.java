package com.lei.tang.rabbitmq.hello;

import com.lei.tang.rabbitmq.domain.User;
import com.lei.tang.rabbitmq.exchange.fanout.FanoutRabbitSender;
import com.lei.tang.rabbitmq.exchange.topic.TopicRabbitSender;
import com.lei.tang.rabbitmq.ordinary.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tanglei
 * @date 2019/5/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    HelloSender helloSender;

    @Autowired
    TopicRabbitSender topicRabbitSender;

    @Autowired
    FanoutRabbitSender fanoutRabbitSender;

    /**
     * 单个测试
     *
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        helloSender.send("测试");
    }

    /**
     * 多消费者
     *
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i = 1; i <= 10; i++) {
            helloSender.send(String.valueOf(i));
        }
    }

    @Test
    public void topic() {
        for (int i = 1; i <= 10; i++) {
            topicRabbitSender.send1(new User(Long.valueOf(i), "a"));
        }

        for (int i = 1; i <= 10; i++) {
            topicRabbitSender.send2(new User(Long.valueOf(i),"b" ));
        }
    }

    @Test
    public void fanout(){
        for (int i = 1; i <= 5; i++) {
            fanoutRabbitSender.send("测试Fanout交换机"+i);
        }
    }
}
