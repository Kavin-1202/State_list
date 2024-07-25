package com.ust.State.repo;

import com.ust.State.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Staterepo extends JpaRepository<State,Long> {
    State findByStatecode(String statecode);
}
