package com.stackroute.component;

import com.stackroute.domain.User;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class commandline {

    @Component
    public class CommandLineStartupRunner implements CommandLineRunner {


        private UserRepository userRepository;

        @Autowired
        public void setUserRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            userRepository.save(new User(3, "lag ja gale", "lata mangeshkar", "Woh Kaun Thi?", "awesome"));
        }
    }
}