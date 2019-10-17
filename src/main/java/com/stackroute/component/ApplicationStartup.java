package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@PropertySource("classpath:application.properties")
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {


    private TrackRepository trackRepository;
    @Value("${in.name}")
    private String mysqlUrl;

    //hello
    @Value("${in.name}")
    private String username;
//
//    @Autowired
//    private Environment env;
//
//    private String mysqlUrl1 = env.getProperty("in.name");

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        trackRepository.save(new User(1, mysqlUrl, "mohammad rafi", "hum dono" ,"awesome1"));
    //  System.out.println("url is "+ mysqlUrl1 +"username is"+ username);

    }
}
