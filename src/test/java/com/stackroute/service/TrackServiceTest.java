package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    private User user;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<User> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId(26);
        user.setName("Jonny");
        user.setSinger("Jenny");
        user.setFilm("Jonny123");
        user.setComments("Jonny123");
        list = new ArrayList<>();
        list.add(user);


    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((User)any())).thenReturn(user);
        User savedUser = trackService.saveUser(user);
        assertEquals(user,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(user);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((User)any())).thenReturn(null);
        User savedUser = trackService.saveUser(user);
        System.out.println("savedUser" + savedUser);
        assertEquals(user,savedUser);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        trackRepository.save(user);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<User> userlist = trackService.getAllUsers();
        assertEquals(list,userlist);
    }


    @Test
    public void findTitleByName() throws Exception{
        trackRepository.save(user);
        when(trackService.findTitleByName(any())).thenReturn(list);
        List<User> tracks = trackService.findTitleByName(user.getName());
        assertEquals(tracks, list);
    }


}