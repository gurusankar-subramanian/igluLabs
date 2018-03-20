package com.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jwt.domain.Tasks;

/**
 * Repository for tasks table
 * @author Guru Sankar
 *
 */
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

	@Query("select task from Tasks task where date=:currentDate")
	List<Tasks> findByDate(@Param("currentDate") String currentDate);
}
