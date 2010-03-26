package com.germinus.sample.dao;

import java.util.List;

import com.germinus.sample.model.Item;

public class ItemDaoTest extends BaseDaoTestCase {

  private GenericDao<Item, Long> dao;

  public void setItemDao(final GenericDao<Item, Long> dao) {
    this.dao = dao;
  }

  public void testGetItemInvalid() throws Exception {

    try {

      final Item item = dao.get(1L);

      assertNull(item);

    }
    catch (final Exception e) {
      assertNotNull(e);
    }
  }

  public void testSaveItem() throws Exception {
    final Item newItem = new Item();
    newItem.setName("Objetaco");
    newItem.setDescription("Un objeto de prueba");

    dao.save(newItem);
    flush();

    log.info("saved new item: " + newItem.toString());

    final List<Item> items = dao.getAll();
    assertNotNull(items.size() > 0);
  }
}
