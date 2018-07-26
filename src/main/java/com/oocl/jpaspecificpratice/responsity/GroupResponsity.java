package com.oocl.jpaspecificpratice.responsity;

import com.oocl.jpaspecificpratice.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupResponsity  extends JpaRepository<Group,Integer> {
}
