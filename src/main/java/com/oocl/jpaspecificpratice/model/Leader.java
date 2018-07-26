package com.oocl.jpaspecificpratice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.jmx.export.annotation.ManagedResource;

import javax.persistence.*;

@Table(name="leader")
@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="klass_Id")
    private Klass klass;

    public Leader(Klass klass) {
        this.klass = klass;
    }

    public Leader() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Leader(String name, Klass klass) {
        this.name = name;
        this.klass = klass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
