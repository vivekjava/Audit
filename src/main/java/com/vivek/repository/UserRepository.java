package com.vivek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
