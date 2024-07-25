package com.runtime.runtime.repository;

import com.runtime.runtime.model.Pace;
import com.runtime.runtime.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaceRepository extends JpaRepository<Pace, Long> {
}
