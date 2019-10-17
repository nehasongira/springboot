package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public User saveUser(User user) throws  TrackAlreadyExistsException;
    public List<User> getAllUsers();
    public void deleteUser(int id) ;
    public String UpdateComments(User user) ;
    public List<User> findTitleByName(String trackName) throws TrackNotFoundException;
   // public void updateUser(int id,String comment);
}
