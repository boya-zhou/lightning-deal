package com.seckillhigh.rabbitmq;


import com.seckillhigh.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgSender {

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void send(String message){

//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE, message);
    }


}
