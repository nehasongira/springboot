package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


//@PropertySource("classpath:application.properties")
    @Component
    public class commandline implements CommandLineRunner {
//
//    @Autowired
//   private Environment env;
//
//    String mysqlUrl1 = env.getProperty("in.name");
        private UserRepository userRepository;

        @Autowired
        public void setUserRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            userRepository.save(new User(3, "lag ja gale", "lata mangeshkar", "Woh Kaun Thi?", "awesome"));
            //System.out.println(mysqlUrl1);
        }
    }
