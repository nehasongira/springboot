package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//@PropertySource("classpath:application.properties")
    @Component
    public class commandline implements CommandLineRunner {
//
//    @Autowired
//   private Environment env;
//
//    private String mysqlUrl1 = env.getProperty("in.name");
        private TrackRepository trackRepository;

        @Autowired
        public void setTrackRepository(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            trackRepository.save(new User(3, "lag ja gale", "lata mangeshkar", "Woh Kaun Thi?", "awesome"));

        }
    }
