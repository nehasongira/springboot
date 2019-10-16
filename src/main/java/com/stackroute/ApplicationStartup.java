package com.stackroute;

import com.stackroute.domain.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String sql = "SELECT * FROM User;";
        List<User> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (u == null || u.size() <= 0) {
            User user = new User();
            user.setId(1);
            user.setName("abhi na jao chhod");
            user.setFilm("hum dono");
            user.setSinger("Mohammed Rafi");
            user.setComments("awesome");


        }
    }
}}
