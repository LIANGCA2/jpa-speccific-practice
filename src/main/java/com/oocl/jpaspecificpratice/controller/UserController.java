package com.oocl.jpaspecificpratice.controller;


import com.oocl.jpaspecificpratice.model.Group;
import com.oocl.jpaspecificpratice.model.Klass;
import com.oocl.jpaspecificpratice.model.Leader;
import com.oocl.jpaspecificpratice.model.User;
import com.oocl.jpaspecificpratice.responsity.GroupRepository;
import com.oocl.jpaspecificpratice.responsity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findAllUser(){
        return userRepository
                .findAll();
    }

    @Transactional
    @GetMapping(value = "/group",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> findAllGroup(){
        return groupRepository
                .findAll();
    }


    @Transactional
    @PostMapping(value = "",produces=MediaType.APPLICATION_JSON_VALUE)
    public User insertUser(@RequestBody User user){
        if(user.getGroupList()!=null&&user.getGroupList().size()!=0) {
            user.getGroupList().stream().forEach((group) -> {
                        if (group.getUserList() == null) {
                            List<User> userArrayList = Arrays.asList(user);
                            group.setUserList(userArrayList);
                        } else {
                            group.getUserList().add(user);
                        }
                        groupRepository.save(group);
                    }
            );
        }
        return  userRepository.save(user);
    }


    @Transactional
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> deleteUser(@PathVariable Integer id){

        userRepository.deleteById(id);

        return userRepository.findAll();
    }


    @Transactional
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<User> updateUser(@PathVariable Integer id,@RequestBody User user){

        user.setId(id);
        userRepository.save(user);
       return userRepository.findAll();
    }




}
