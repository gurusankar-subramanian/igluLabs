package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.domain.StatusMaster;

/**
 * Repository for status master table
 * @author Guru Sankar
 *
 */
@Repository
public interface StatusMasterRepository extends JpaRepository<StatusMaster, Long> {
	StatusMaster findByStatusCode(String statusCode);
}
