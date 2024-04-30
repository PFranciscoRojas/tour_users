package com.tour.user.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("usuarioExchange");
    }

    @Bean
    public Queue alojamientoQueue() {
        return new Queue("alojamientoQueue", true);
    }

    @Bean
    public Binding alojamientoBinding(Queue alojamientoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(alojamientoQueue).to(exchange).with("usuario.alojamiento");
    }

    @Bean
    public Queue vuelosQueue() {
        return new Queue("vuelosQueue", true);
    }

    @Bean
    public Binding vuelosBinding(Queue vuelosQueue, TopicExchange exchange) {
        return BindingBuilder.bind(vuelosQueue).to(exchange).with("usuarios.vuelos");
    }

    @Bean
    public Queue restaurantesQueue() {
        return new Queue("restaurantesQueue", true);
    }

    @Bean
    public Binding restauranteBinding(Queue restaurantesQueue, TopicExchange exchange) {
        return BindingBuilder.bind(restaurantesQueue).to(exchange).with("usuario.restaurante");
    }

    @Bean
    public Queue eventosQueue() {
        return new Queue("eventosQueue", true);
    }

    @Bean
    public Binding eventosBinding(Queue eventosQueue, TopicExchange exchange) {
        return BindingBuilder.bind(eventosQueue).to(exchange).with("usuario.eventos");
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange("usuario-exchange");
    }

    @Bean
    Queue queue() {
        return new Queue("usuario-cola", true);
    }

    @Bean
    Binding binding(DirectExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("usuario-key");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
