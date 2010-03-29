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

  private static final Logger logger =
    Logger.getLogger(AbstractPersistenceTemplate.class);

  private SimpleJdbcInsert simpleJdbcInsert;
  private SimpleJdbcTemplate simpleJdbcTemplate;
  private DataSource dataSource;

  @Override
  public void batchUpdate(final String sql, final List<Object[]> batchArgs) {
    try {
      this.getSimpleJdbcTemplate().batchUpdate(sql, batchArgs);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
  }

  protected SimpleJdbcInsert createSimpleJdbcInsert() {
    this.simpleJdbcInsert = new SimpleJdbcInsert(this.getDataSource());
    return this.simpleJdbcInsert;
  }

  @Override
  public KeyHolder executeAndReturnKeyHolderJdbcInsert(
    final Map<String, Object> args) {
    KeyHolder keyHolder = null;
    try {
      keyHolder = this.getSimpleJdbcInsert().executeAndReturnKeyHolder(args);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return keyHolder;
  }

  @Override
  public KeyHolder executeAndReturnKeyHolderJdbcInsert(
    final SqlParameterSource parameterSource) {
    KeyHolder keyHolder = null;
    try {
      keyHolder =
        this.getSimpleJdbcInsert().executeAndReturnKeyHolder(parameterSource);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return keyHolder;
  }

  @Override
  public Number executeAndReturnKeyJdbcInsert(final Map<String, Object> args) {
    Number number = null;
    try {
      number = this.getSimpleJdbcInsert().executeAndReturnKey(args);
    }
    catch (final Exception e) {
      logger.error(e);
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return number;
  }

  @Override
  public Number executeAndReturnKeyJdbcInsert(
    final SqlParameterSource parameterSource) {
    Number number = null;
    try {
      number = this.getSimpleJdbcInsert().executeAndReturnKey(parameterSource);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return number;
  }

  @Override
  public void executeBatchJdbcInsert(final Map<String, Object>[] batch) {
    try {
      this.getSimpleJdbcInsert().executeBatch(batch);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public void executeBatchJdbcInsert(final SqlParameterSource[] batch) {
    try {
      this.getSimpleJdbcInsert().executeBatch(batch);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public void executeInsertJdbcInsert(final SqlParameterSource parameterSource) {
    try {
      this.getSimpleJdbcInsert().execute(parameterSource);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
  }

  @Override
  public void executeJdbcInsert(final Map<String, Object> args) {
    try {
      this.getSimpleJdbcInsert().execute(args);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
  }

  public DataSource getDataSource() {
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

  public SimpleJdbcTemplate getSimpleJdbcTemplate() {
    return this.simpleJdbcTemplate;
  }

  @Override
  @SuppressWarnings("deprecation")
  public List<?> query(final String sql, final ParameterizedRowMapper<?> rm,
    final Object... args) {

    List<?> result = null;

    try {
      result = this.getSimpleJdbcTemplate().query(sql, rm, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  public Integer queryForInt(final String sql, final Object... args) {
    Integer result = null;
    try {
      result =
        Integer.valueOf(this.getSimpleJdbcTemplate().queryForInt(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  public Long queryForLong(final String sql, final Object... args) {
    Long result = null;
    try {
      result =
        Long.valueOf(this.getSimpleJdbcTemplate().queryForLong(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  public Long queryForLongLocal(final String sql, final Object... args) {
    Long result = null;
    try {
      result =
        Long.valueOf(this.getSimpleJdbcTemplate().queryForLong(sql, args));
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  public Object queryForObject(final String sql, final Class<?> requiredType,
    final Object... args) {
    Object result;
    try {
      result =
        this.getSimpleJdbcTemplate().queryForObject(sql, requiredType, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  @SuppressWarnings("deprecation")
  public Object queryForObject(final String sql,
    final ParameterizedRowMapper<?> rm, final Object... args) {

    Object result;

    try {
      result = this.getSimpleJdbcTemplate().queryForObject(sql, rm, args);
    }
    catch (final EmptyResultDataAccessException erdae) {
      logger.debug(erdae);
      result = null;
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  @Override
  public Object queryForObjectLocal(final String sql,
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
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }

  public void setDataSource(final DataSource dataSource) {
    this.dataSource = dataSource;
    this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
  }

  @Override
  public int update(final String sql, final Object... args) {
    int result = 0;
    try {
      result = this.getSimpleJdbcTemplate().update(sql, args);
    }
    catch (final Exception e) {
      logger.error(e.getMessage(), e.getCause());
      throw new PersistenceTemplateException(e.getMessage(), e.getCause());
    }
    return result;
  }
}
