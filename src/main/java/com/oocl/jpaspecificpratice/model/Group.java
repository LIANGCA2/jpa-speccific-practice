package com.oocl.jpaspecificpratice.model;


import javax.persistence.*;
import java.util.List;

@Table(name = "tw_group")
public class Group {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "group")
    private List<User> userList;

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
