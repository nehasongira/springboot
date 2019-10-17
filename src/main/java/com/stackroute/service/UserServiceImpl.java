package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
@Profile("original")
//@PropertySource("classpath:application.properties")
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) throws TrackAlreadyExistsException {
       if(userRepository.existsById(user.getId()))
       {
           throw new TrackAlreadyExistsException("track already exist");
       }
        User savedUser= (User) userRepository.save(user);
        if(savedUser==null)
        {
            throw new TrackAlreadyExistsException("user already exist");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id)  {

        userRepository.deleteById(id);

    }
    @Override
    public boolean UpdateComments(int trackId,String trackComments){
        User user = userRepository.getOne(trackId);
        user.setComments(trackComments);
        userRepository.save(user);
        return true;
    }
    @Override
    public List<User> findTitleByName(String trackName) throws TrackNotFoundException{
        List<User> list= userRepository.findTitleByName(trackName);
        return  list;
    }
//    @Override
//    public void updateUser(int id, String comment) {
//        userRepository.updateComment(id,comment);
//    }


}
