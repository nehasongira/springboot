package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Profile("dev")
public class TrackDummyServiceImpl implements TrackService {

    @Override
    public User saveUser(User user) throws TrackAlreadyExistsException {
        System.out.println("savecreated");
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("getallcreated");
        return null;
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("deletecreated");

    }

    @Override
    public boolean UpdateComments(int trackId, String trackComments) {
        System.out.println("updatecreated");
        return false;
    }

    @Override
    public List<User> findTitleByName(String trackName) {
        System.out.println("searchcreated");
        return null;
    }
}
