package com.runtime.runtime.repository;

import com.runtime.runtime.model.PaceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaceRequestRepository extends JpaRepository<PaceRequest, Long> {
}
