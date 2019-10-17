package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
@Profile("prod")
//@PropertySource("classpath:application.properties")
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public User saveUser(User user) throws TrackAlreadyExistsException {
       if(trackRepository.existsById(user.getId()))
       {
           throw new TrackAlreadyExistsException("track already exist");
       }
        User savedUser= (User) trackRepository.save(user);
        if(savedUser==null)
        {
            throw new TrackAlreadyExistsException("user already exist");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return trackRepository.findAll();
    }

    @Override
    public void deleteUser(int id)  {

        trackRepository.deleteById(id);

    }
    @Override
    public String UpdateComments(User user){
        if(!(trackRepository.findById(user.getId()).isPresent())) {
        trackRepository.save(user);

        }
    return "Updated successfully" ;}
    @Override
    public List<User> findTitleByName(String trackName) throws TrackNotFoundException{
        List<User> list= trackRepository.findTitleByName(trackName);
        return  list;
    }
//    @Override
//    public void updateUser(int id, String comment) {
//        userRepository.updateComment(id,comment);
//    }


}
