package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private UserService userService;


    public ApplicationStartup(@Autowired UserService userService) {
        this.userService = userService;

    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userService.add(new Artist("ARTIST-SAMPLE", "None", ""));
        Song s = new Song();
        s.setId("ID-SAMPLE");
        s.setName("Listener Song");
        s.setDuration(0);
//            s.setUrl("");
        s.setArtist(new Artist("ARTIST-SAMPLE", "None", ""));
    }
}
