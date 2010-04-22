package com.germinus.sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.mvc.SimpleFormController;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;

public class BookEditController extends SimpleFormController implements
  InitializingBean {

  private BookService bookService;

  public final void afterPropertiesSet() throws Exception {
    if (this.bookService == null) {
      throw new IllegalArgumentException("A BookService is required");
    }
  }

  @Override
  protected final Object formBackingObject(final PortletRequest request)
    throws Exception {

    Book book;

    try {
      final Integer key = new Integer(request.getParameter("book"));
      book = bookService.getBook(key);
    }
    catch (final NumberFormatException ex) {
      book = new Book();
    }

    return book;
  }

  @Override
  protected final void handleInvalidSubmit(final ActionRequest request,
    final ActionResponse response) throws Exception {
    response.setRenderParameter("action", "books");
  }

  @Override
  protected final void initBinder(final PortletRequest request,
    final PortletRequestDataBinder binder) throws Exception {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
      dateFormat, true));
    binder.setAllowedFields(new String[] { "author", "title", "description",
      "availability", "count" });
  }

  @Override
  public final void onSubmitAction(final ActionRequest request,
    final ActionResponse response, final Object command,
    final BindException errors) throws Exception {

    final Book book = (Book) command;
    Integer key;

    try {
      key = new Integer(request.getParameter("book"));
    }
    catch (final NumberFormatException ex) {
      key = null;
    }

    if (key == null) {
      bookService.addBook(book);
    }
    else {
      bookService.saveBook(book);
    }

    response.setRenderParameter("action", "books");
  }

  @Override
  protected final ModelAndView renderInvalidSubmit(final RenderRequest request,
    final RenderResponse response) throws Exception {
    return null;
  }

  public final void setBookService(final BookService bookService) {
    this.bookService = bookService;
  }
}
