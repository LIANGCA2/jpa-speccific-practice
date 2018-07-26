package com.oocl.jpaspecificpratice.responsity;

import com.oocl.jpaspecificpratice.model.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderResponsity extends JpaRepository<Leader,Integer> {
}
