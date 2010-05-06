package com.germinus.sample.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.djimenez.model.item.Item;

@ContextConfiguration(locations = {
  "classpath:/context/applicationContext-resources.xml",
  "classpath:/context/applicationContext-dao.xml" })
public class ItemDaoTest extends BaseDaoTestCase {

  @Autowired
  private GenericDao<Item, Long> itemDao;

  @Test
  public final void testGetItemInvalid() throws Exception {

    try {

      final Item item = itemDao.get(1L);

      org.junit.Assert.assertNull(item);

    }
    catch (final Exception e) {
      org.junit.Assert.assertNotNull(e);
    }
  }

  @Test
  public final void testSaveItem() throws Exception {

    final Item newItem = new Item();

    newItem.setName("Objetaco");
    newItem.setDescription("Un objeto de prueba");

    itemDao.save(newItem);
    flush();

    log.info("saved new item: " + newItem.toString());

    final List<Item> items = itemDao.getAll();

    org.junit.Assert.assertNotNull(items.size() > 0);

  }
}
