package com.stackroute.service;

import com.stackroute.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(int id);
    public boolean UpdateComments(int trackId,String trackComments);
    public List<User> findTitleByName(String trackName);
   // public void updateUser(int id,String comment);
}
