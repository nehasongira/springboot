package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PropertySource("classpath:application-mongo.properties")
@RestController
@RequestMapping(value = "/api/vl")
public class TrackController {
    TrackService trackService;
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }
    @PostMapping("users")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try{
            trackService.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully", HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<List<User>>(trackService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int noteId)
    {
        trackService.deleteUser(noteId);
        return new ResponseEntity<List<User>>(trackService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/update/") public ResponseEntity UpdateComments(@RequestBody User user)
    {       ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<>(trackService.UpdateComments(user), HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/findName/{trackName}")
    public ResponseEntity findTitleByName(@PathVariable String trackName)
    {
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<>((trackService.findTitleByName(trackName)), HttpStatus.OK);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
//    @PutMapping("/users/{id}/{comment}")
//    public ResponseEntity<?> updateUser(@PathVariable(value = "id") int noteId, @PathVariable(value = "comments") String userComment)
//    {
//        userService.updateUser(noteId,userComment);
//
//        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
//    }


}
