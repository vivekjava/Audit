/**
 * 
 */
package com.vivek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivek.entity.Address;

/**
 * @author vivek
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address,Long>  {
	
}
