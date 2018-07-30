package com.oocl.jpaspecificpratice.controller;


import com.oocl.jpaspecificpratice.model.Klass;
import com.oocl.jpaspecificpratice.model.Leader;
import com.oocl.jpaspecificpratice.responsity.KlassResponsity;
import com.oocl.jpaspecificpratice.responsity.LeaderResponsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class KlassController {

@Autowired
private LeaderResponsity leaderResponsity;
@Autowired
private KlassResponsity klassResponsity;




    @Transactional
    @PostMapping(value = "/klass",produces=MediaType.APPLICATION_JSON_VALUE)
    public Klass addKlass(@RequestBody Klass klass){
        Leader leader = klass.getLeader();
                if(leader!=null){
                    leader.setKlass(klass);
                }

        return  klassResponsity.save(klass);
    }git



    @Transactional
    @GetMapping(value = "/klasses",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Klass> findAllKlasses(){
        return klassResponsity.findAll();
    }

    @Transactional
    @GetMapping(path = "klasses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass get(@PathVariable("id")Integer id) {
        Klass klass = klassResponsity.findById(id).get();
        return klass;
    }


    @Transactional
    @PutMapping(path = "klasses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get(@PathVariable("id")Integer id, @RequestBody Klass klass) {
        Leader leader = klass.getLeader();
        if(leader!=null){
            leader.setKlass(klass);
        }
        klassResponsity.save(klass);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping(path="klasses/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Klass delete(@PathVariable("id")Integer id){
        Klass klass = klassResponsity.findById(id).get();
        klassResponsity.delete(klass);
        return klass;
    }






}
