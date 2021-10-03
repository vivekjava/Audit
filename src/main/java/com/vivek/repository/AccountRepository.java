package com.vivek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
