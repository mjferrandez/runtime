package com.runtime.runtime.repository;

import com.runtime.runtime.model.DistanceRequest;
import com.runtime.runtime.model.Pace;
import com.runtime.runtime.model.TotalTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRequestRepository extends JpaRepository<DistanceRequest, Long> {
}
