package com.stackroute.repository;


import com.stackroute.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private User user;

    @Before
    public void setUp()
    {
        user = new User();
        user.setId(101);

        user.setSinger("Jenny");
        user.setFilm("Jonny123");
        user.setComments("Jonny123");
        user.setName("Jonny");
    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        trackRepository.save(user);
        User fetchUser = trackRepository.findById(user.getId()).get();
        Assert.assertEquals(101,fetchUser.getId());

    }

    @Test
    public void testSaveUserFailure(){
        User testUser = new User(2,"john","jack","Harry123","done");
        trackRepository.save(user);
        User fetchUser = trackRepository.findById(user.getId()).get();
        Assert.assertNotSame(testUser,user);
    }
//
    @Test
    public void testGetAllUser(){
        User u = new User(1,"Jenny","he","Johny12","awesome");
        User u1 = new User(3,"Jenny","bye","Harry12","dooone");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<User> list = trackRepository.findAll();
        Assert.assertEquals("Jenny",list.get(1).getName());

//
//
//
   }


}