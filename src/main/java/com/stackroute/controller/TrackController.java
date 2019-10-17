package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
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

    @PutMapping("/update/{trackId}") public ResponseEntity UpdateComments(@RequestBody String trackcomments,int trackId)
    {       ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<>(trackService.UpdateComments(trackId,trackcomments), HttpStatus.OK);
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
