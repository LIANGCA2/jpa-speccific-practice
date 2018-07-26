package com.oocl.jpaspecificpratice.responsity;

import com.oocl.jpaspecificpratice.model.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassResponsity extends JpaRepository<Klass,Integer> {
}
