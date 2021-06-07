/**
 * 
 */
package com.rishad.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishad.model.Account;

/**
 * @author rishadali
 *
 */
@Repository
public interface AccountRepo extends CrudRepository<Account, String>
{
	
}
