package com.djimenez.persistence.core.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;

/**
 * @author a.pastoriza.barcia
 * @version 1.0
 */
public abstract class AbstractPersistenceTemplate implements
  PersistenceTemplateOperations {

  private static Logger logger =
    Logger.getLogger(AbstractPersistenceTemplate.class);

  private SimpleJdbcInsert simpleJdbcInsert;
  private SimpleJdbcTemplate simpleJdbcTemplate;
  private DataSource dataSource;

  @Override
  public final void batchUpdate(final String sql, final List<Object[]> batchArgs) {

    this.getSimpleJdbcTemplate().batchUpdate(sql, batchArgs);
  }

  protected final SimpleJdbcInsert createSimpleJdbcInsert() {
    this.simpleJdbcInsert = new SimpleJdbcInsert(this.getDataSource());
    return this.simpleJdbcInsert;
  }

  @Override
  public final KeyHolder executeAndReturnKeyHolderJdbcInsert(
    final Map<String, Object> args) {
    KeyHolder keyHolder = null;

    keyHolder = this.getSimpleJdbcInsert().executeAndReturnKeyHolder(args);

    return keyHolder;
  }

  @Override
  public final KeyHolder executeAndReturnKeyHolderJdbcInsert(
    final SqlParameterSource parameterSource) {

    KeyHolder keyHolder = null;
    keyHolder =
      this.getSimpleJdbcInsert().executeAndReturnKeyHolder(parameterSource);

    return keyHolder;
  }

  @Override
  public final Number executeAndReturnKeyJdbcInsert(
    final Map<String, Object> args) {
    Number number = null;

    number = this.getSimpleJdbcInsert().executeAndReturnKey(args);

    return number;
  }

  @Override
  public final Number executeAndReturnKeyJdbcInsert(
    final SqlParameterSource parameterSource) {
    Number number = null;

    number = this.getSimpleJdbcInsert().executeAndReturnKey(parameterSource);

    return number;
  }

  @Override
  public final void executeBatchJdbcInsert(final Map<String, Object>[] batch) {

    this.getSimpleJdbcInsert().executeBatch(batch);

  }

  @Override
  public final void executeBatchJdbcInsert(final SqlParameterSource[] batch) {

    this.getSimpleJdbcInsert().executeBatch(batch);
  }

  @Override
  public final void executeInsertJdbcInsert(
    final SqlParameterSource parameterSource) {

    this.getSimpleJdbcInsert().execute(parameterSource);
  }

  @Override
  public final void executeJdbcInsert(final Map<String, Object> args) {

    this.getSimpleJdbcInsert().execute(args);
  }

  public final DataSource getDataSource() {
    if (this.dataSource == null) {
      throw new PersistenceTemplateException(
        "Trying to use DataSource but was null!!");
    }
    return this.dataSource;
  }

  private SimpleJdbcInsert getSimpleJdbcInsert() {
    if (this.simpleJdbcInsert == null) {
      logger.warn("simpleJdbcInsert was null. Creating...");
      this.simpleJdbcInsert = new SimpleJdbcInsert(this.getDataSource());
    }
    return this.simpleJdbcInsert;
  }

  public final SimpleJdbcTemplate getSimpleJdbcTemplate() {
    return this.simpleJdbcTemplate;
  }

  @Override
  @SuppressWarnings("deprecation")
  public final List<?> query(final String sql,
    final ParameterizedRowMapper<?> rm, final Object... args) {

    List<?> result = null;

    try {
      result = this.getSimpleJdbcTemplate().query(sql, rm, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  public final Integer queryForInt(final String sql, final Object... args) {
    Integer result = null;
    try {
      result =
        Integer.valueOf(this.getSimpleJdbcTemplate().queryForInt(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  public final Long queryForLong(final String sql, final Object... args) {

    Long result = null;

    try {
      result =
        Long.valueOf(this.getSimpleJdbcTemplate().queryForLong(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  public final Long queryForLongLocal(final String sql, final Object... args) {
    Long result = null;

    try {
      result =
        Long.valueOf(this.getSimpleJdbcTemplate().queryForLong(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  public final Object queryForObject(final String sql,
    final Class<?> requiredType, final Object... args) {

    Object result;

    try {
      result =
        this.getSimpleJdbcTemplate().queryForObject(sql, requiredType, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  @SuppressWarnings("deprecation")
  public final Object queryForObject(final String sql,
    final ParameterizedRowMapper<?> rm, final Object... args) {

    Object result;

    try {
      result = this.getSimpleJdbcTemplate().queryForObject(sql, rm, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  @Override
  public final Object queryForObjectLocal(final String sql,
    final Class<?> requiredType, final Object... args) {
    Object result;
    try {
      result =
        this.getSimpleJdbcTemplate().queryForObject(sql, requiredType, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }

    return result;
  }

  public final void setDataSource(final DataSource dataSource) {
    this.dataSource = dataSource;
    this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
  }

  @Override
  public final int update(final String sql, final Object... args) {
    int result = 0;

    result = this.getSimpleJdbcTemplate().update(sql, args);
    return result;
  }
}
