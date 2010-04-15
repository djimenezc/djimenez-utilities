package com.germinus.sample.dao;

import java.util.Map;

import org.springframework.mock.web.portlet.MockRenderRequest;
import org.springframework.mock.web.portlet.MockRenderResponse;
import org.springframework.web.portlet.ModelAndView;

import com.germinus.sample.controller.BookViewController;
import com.germinus.sample.model.Book;

public class TestBookViewController extends SimpleSpringTestCase {

  public final void testBookViewController() throws Exception {

    final BookViewController controller =
      (BookViewController) getBooksPortletContext().getBean(
        "bookViewController");

    final MockRenderRequest request = new MockRenderRequest();
    final MockRenderResponse response = new MockRenderResponse();

    request.addParameter("book", "1");

    final ModelAndView mav = controller.handleRenderRequest(request, response);
    assertNotNull(mav);

    getLogger().info("view: " + mav.getViewName());

    @SuppressWarnings("unchecked")
    final Map<String, Book> model = mav.getModel();

    assertTrue(model.containsKey("book"));
    final Book book = model.get("book");

    getLogger().info("book.author: " + book.getAuthor());
    getLogger().info("book.title: " + book.getTitle());
    getLogger().info("book.description: " + book.getDescription());
    getLogger().info("book.count: " + book.getCount());

  }

}
