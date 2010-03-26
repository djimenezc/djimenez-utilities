package com.germinus.sample.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;

public class BooksController extends AbstractController implements
  InitializingBean {

  private BookService bookService;

  public void afterPropertiesSet() throws Exception {
    if (this.bookService == null) {
      throw new IllegalArgumentException("A BookService is required");
    }
  }

  @Override
  public ModelAndView handleRenderRequestInternal(final RenderRequest request,
    final RenderResponse response) throws Exception {

    final Map<String, SortedSet<Book>> model =
      new HashMap<String, SortedSet<Book>>();

    model.put("books", bookService.getAllBooks());

    return new ModelAndView("booksView", "model", model);
  }

  public void setBookService(final BookService bookService) {
    this.bookService = bookService;
  }
}