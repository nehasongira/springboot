package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("dummy")
public class TrackDummyServiceImpl implements UserService {

    @Override
    public User saveUser(User user) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public boolean UpdateComments(int trackId, String trackComments) {
        return false;
    }

    @Override
    public List<User> findTitleByName(String trackName) {
        return null;
    }
}
