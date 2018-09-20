package com.seckillhigh.config;

import com.seckillhigh.rabbitmq.MsgReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";

    public static final String QUEUE = "Queue";

    @Bean
    Queue queue(){
        return new Queue(RabbitConfig.QUEUE, true);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(RabbitConfig.TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MsgReceiver msgReceiver){
        return new MessageListenerAdapter(msgReceiver,"receive");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RabbitConfig.QUEUE);
        container.setMessageConverter(new Jackson2JsonMessageConverter());
        container.setMessageListener(listenerAdapter);
        return container;
    }

}
