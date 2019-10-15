package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vl")
public class UserController {
    UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("users")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully", HttpStatus.CREATED);
        }catch (Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }
        return responseEntity;

    }
    @GetMapping("users")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") int noteId)
    {
        userService.deleteUser(noteId);
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/update")   public ResponseEntity UpdateComments(@RequestBody User user)
    {       ResponseEntity responseEntity;

            responseEntity= new ResponseEntity<>(userService.UpdateComments(user.getId(),user.getComments()), HttpStatus.OK);

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
