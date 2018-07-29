package com.oocl.jpaspecificpratice.responsity;


import com.oocl.jpaspecificpratice.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
}
