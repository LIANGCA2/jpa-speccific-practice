package com.oocl.jpaspecificpratice.controller;

import com.oocl.jpaspecificpratice.model.User;
import com.oocl.jpaspecificpratice.responsity.GroupResponsity;
import com.oocl.jpaspecificpratice.responsity.UserResponsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private GroupResponsity groupResponsity;
    @Autowired
    private UserResponsity userResponsity;

    @PostMapping("/User")
    public User insertUser(@RequestBody User user){
        user.getGroupList().stream().forEach(item->{
            List<User> userList = item.getUserList();
            if(userList!=null){
                item.getUserList().add(user);
            }else {
                List<User> users = new ArrayList<>();
                users.add(user);
                item.setUserList(users);
            }
        });
        return userResponsity.save(user);
    }
}
