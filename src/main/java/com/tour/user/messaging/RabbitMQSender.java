package com.tour.user.messaging;


import com.tour.user.domain.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarUsuario(User user) {
        rabbitTemplate.convertAndSend("usuario-exchange", "usuario-key", user);
    }

}
