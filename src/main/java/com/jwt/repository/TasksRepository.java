package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jwt.domain.Tasks;

/**
 * Repository for tasks table
 * @author Guru Sankar
 *
 */
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
