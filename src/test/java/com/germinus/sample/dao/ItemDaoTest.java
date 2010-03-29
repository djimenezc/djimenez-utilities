package com.germinus.sample.dao;

import com.germinus.sample.model.Item;

import java.util.List;

public class ItemDaoTest extends BaseDaoTestCase {
    private GenericDao<Item, Long> dao;

    public void setItemDao(GenericDao<Item, Long> dao) {
        this.dao = dao;
    }

    public void testGetItemInvalid() throws Exception {
        Item item = null;
        try {
            item = dao.get(1L);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    public void testSaveItem() throws Exception {
        Item newItem = new Item();
        newItem.setName("Objetaco");
        newItem.setDescription("Un objeto de prueba");

        dao.save(newItem);
        flush();

        log.info("saved new item: " + newItem.toString());

        List<Item> items = dao.getAll();
        assertNotNull(items.size() > 0);
    }
}
