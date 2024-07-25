package com.runtime.runtime.repository;

import com.runtime.runtime.model.Distance;
import com.runtime.runtime.model.Pace;
import com.runtime.runtime.model.TotalTime;
import com.runtime.runtime.model.TotalTimeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalTimeRequestRepository extends JpaRepository<TotalTimeRequest, Long> {
}
