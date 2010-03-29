package com.germinus.sample.dao;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.germinus.sample.model.Item;

@SuppressWarnings("deprecation")
public class ItemDaoTest extends AbstractDependencyInjectionSpringContextTests {

  protected final Log log = LogFactory.getLog(getClass());
  protected ResourceBundle rb;

  @Autowired
  private GenericDao<Item, Long> itemDao;

  @Override
  protected String[] getConfigLocations() {
    setAutowireMode(AUTOWIRE_BY_NAME);
    return new String[] { "classpath:context/applicationContext-resources.xml",
      "classpath:context/applicationContext-dao.xml", };
  }

  /**
   * @param itemDao
   *          the itemDao to set
   */
  public void setItemDao(final GenericDao<Item, Long> itemDao) {
    this.itemDao = itemDao;
  }

  @Test
  public void testGetItemInvalid() throws Exception {

    try {

      final Item item = itemDao.get(1L);

      org.junit.Assert.assertNull(item);

    }
    catch (final Exception e) {
      org.junit.Assert.assertNotNull(e);
    }
  }

  @Test
  public void testSaveItem() throws Exception {

    final Item newItem = new Item();

    newItem.setName("Objetaco");
    newItem.setDescription("Un objeto de prueba");

    itemDao.save(newItem);
    // flush();

    log.info("saved new item: " + newItem.toString());

    final List<Item> items = itemDao.getAll();

    org.junit.Assert.assertNotNull(items.size() > 0);
  }

}
