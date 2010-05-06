package com.djimenez.test.dao;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for running transactional DAO tests.
 * 
 * @author mraible
 */
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public abstract class AbstracBaseDaoTransactionalTestCase extends
  AbstracBaseDaoTestCase {

}
