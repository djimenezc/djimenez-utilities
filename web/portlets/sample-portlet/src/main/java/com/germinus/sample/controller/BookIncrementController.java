package com.germinus.sample.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;

public class BookIncrementController extends AbstractController implements
  InitializingBean {

  private BookService bookService;

  public final void afterPropertiesSet() throws Exception {
    if (this.bookService == null) {
      throw new IllegalArgumentException("A BookService is required");
    }
  }

  @Override
  public final void handleActionRequestInternal(final ActionRequest request,
    final ActionResponse response) throws Exception {
    // get the id and delete it
    final Integer id = new Integer(request.getParameter("book"));
    final Integer increment = new Integer(request.getParameter("increment"));
    final Book book = bookService.getBook(id);
    book.incrementCount(increment);
    bookService.saveBook(book);
    // change action parameter to go to default view
    response.setRenderParameter("action", "books");
  }

  public final void setBookService(final BookService bookService) {
    this.bookService = bookService;
  }
}