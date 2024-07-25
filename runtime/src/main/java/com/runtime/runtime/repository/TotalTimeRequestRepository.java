package com.runtime.runtime.repository;

import com.runtime.runtime.model.TotalTimeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalTimeRequestRepository extends JpaRepository<TotalTimeRequest, Long> {
}
