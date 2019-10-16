package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {


    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        userRepository.save(new User(1, "abhi na jaho chhod", "mohammad rafi", "hum dono" ,"awesome"));

    }
}
