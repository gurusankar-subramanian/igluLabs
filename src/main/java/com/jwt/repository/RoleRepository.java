package com.jwt.repository;

import com.jwt.domain.Role;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository for role table
 * @author Guru Sankar
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
