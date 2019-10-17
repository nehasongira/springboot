package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
@PropertySource("classpath:application.properties")
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {


    private UserRepository userRepository;
    @Value("${in.name}")
    private String mysqlUrl;

    //hello
    @Value("${in.name}")
    private String username;


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        userRepository.save(new User(1, mysqlUrl, "mohammad rafi", "hum dono" ,"awesome1"));
//        System.out.println("url is "+ mysqlUrl +"username is"+ username);

    }
}
