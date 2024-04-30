package com.tour.user.messaging;


import com.tour.user.domain.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserEvent(Object message) {
        String routingKeyBase = "usuario.";
        // Puedes modificar estas claves según la convención que prefieras
        rabbitTemplate.convertAndSend("usuarioExchange", routingKeyBase + "alojamiento", message);
        rabbitTemplate.convertAndSend("usuarioExchange", routingKeyBase + "vuelos", message);
        rabbitTemplate.convertAndSend("usuarioExchange", routingKeyBase + "restaurantes", message);
        rabbitTemplate.convertAndSend("usuarioExchange", routingKeyBase + "eventos", message);
    }

}
