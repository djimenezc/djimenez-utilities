package com.djimenez.persistence.core;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.KeyHolder;

/**
 * Database Operations Available in the Persistence Layer. I wraps Spring JDBC
 * Template in order to simplify its usage.
 * 
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public interface PersistenceTemplateOperations {

  void batchUpdate(final String sql, final List<Object[]> batchArgs);

  KeyHolder executeAndReturnKeyHolderJdbcInsert(final Map<String, Object> args);

  KeyHolder executeAndReturnKeyHolderJdbcInsert(
    final SqlParameterSource parameterSource);

  Number executeAndReturnKeyJdbcInsert(final Map<String, Object> args);

  Number executeAndReturnKeyJdbcInsert(final SqlParameterSource parameterSource);

  void executeBatchJdbcInsert(final Map<String, Object>[] batch);

  void executeBatchJdbcInsert(final SqlParameterSource[] batch);

  void executeInsertJdbcInsert(final SqlParameterSource parameterSource);

  void executeJdbcInsert(final Map<String, Object> args);

  List<?> query(final String sql, final ParameterizedRowMapper<?> rm,
    final Object... args);

  Integer queryForInt(final String sql, final Object... args);

  Long queryForLong(final String sql, final Object... args);

  Long queryForLongLocal(final String sql, final Object... args);

  Object queryForObject(final String sql, final Class<?> requiredType,
    final Object... args);

  Object queryForObject(final String sql, final ParameterizedRowMapper<?> rm,
    final Object... args);

  Object queryForObjectLocal(final String sql, final Class<?> requiredType,
    final Object... args);

  int update(final String sql, final Object... args);
}
