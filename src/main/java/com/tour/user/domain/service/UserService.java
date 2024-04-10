package com.tour.user.domain.service;

import com.tour.user.domain.entity.User;
import com.tour.user.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // TODO: lógica para cifrar la contraseña y validar el usuario
        return userRepository.save(user);
    }
}
