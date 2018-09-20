package com.seckillhigh.rabbitmq;

import com.seckillhigh.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgReceiver {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private static Logger log = LoggerFactory.getLogger(MsgReceiver.class);

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(String message){

        log.info(message);
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        // rabbitTemplate.receiveAndConvert(message);
    }
}
