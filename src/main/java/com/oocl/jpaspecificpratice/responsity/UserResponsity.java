package com.oocl.jpaspecificpratice.responsity;

import com.oocl.jpaspecificpratice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponsity extends JpaRepository<User,Integer> {
}
