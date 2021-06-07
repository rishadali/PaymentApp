/**
 * 
 */
package com.rishad.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishad.model.Transaction;

/**
 * @author rishadali
 *
 */
@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Integer>
{
	Iterable<Transaction> findByPaytoOrPayfrom(String payto, String payfrom);
}
