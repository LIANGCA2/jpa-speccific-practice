package com.oocl.jpaspecificpratice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Table(name="klass")
@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @OneToOne(cascade=CascadeType.ALL,mappedBy = "klass",fetch = FetchType.LAZY)
    @JoinColumn(name="leader_Id")
    private Leader leader;

    public Klass(Leader leader) {
        this.leader = leader;
    }

    public Klass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public Klass(String name, Leader leader) {
        this.name = name;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
