package com.lei.tang.rabbitmq.hello;

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
    private HelloSender helloSender;

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
}
