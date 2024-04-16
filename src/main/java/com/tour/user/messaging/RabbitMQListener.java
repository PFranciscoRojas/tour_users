package com.tour.user.messaging;


import com.tour.user.domain.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    @RabbitListener(queues = "usuario-cola")
    public void recibirUsuario(User user) {
        System.out.println("Recibido usuario: " + user.getNombre());
    }

}
