package com.runtime.runtime.repository;

import com.runtime.runtime.model.TotalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalTimeRepository extends JpaRepository<TotalTime, Long> {
}
