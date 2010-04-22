package com.germinus.sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.mvc.AbstractWizardFormController;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;
import com.germinus.sample.web.BookValidator;

class BookAddController extends AbstractWizardFormController {

  private BookService bookService;

  public void afterPropertiesSet() throws Exception {
    if (this.bookService == null) {
      throw new IllegalArgumentException("A BookService is required");
    }
  }

  @Override
  protected void handleInvalidSubmit(final ActionRequest request,
    final ActionResponse response) throws Exception {
    response.setRenderParameter("action", "books");
  }

  @Override
  protected void initBinder(final PortletRequest request,
    final PortletRequestDataBinder binder) throws Exception {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
      dateFormat, true));
    binder.setAllowedFields(new String[] { "author", "title", "description",
      "availability", "count" });
  }

  @Override
  protected void processCancel(final ActionRequest request,
    final ActionResponse response, final Object command,
    final BindException errors) throws Exception {
    response.setRenderParameter("action", "books");
  }

  @Override
  protected void processFinish(final ActionRequest request,
    final ActionResponse response, final Object command,
    final BindException errors) throws Exception {
    bookService.addBook((Book) command);
    response.setRenderParameter("action", "books");
  }

  @Override
  protected ModelAndView renderInvalidSubmit(final RenderRequest request,
    final RenderResponse response) throws Exception {
    return null;
  }

  public void setBookService(final BookService bookService) {
    this.bookService = bookService;
  }

  @Override
  protected void validatePage(final Object command, final Errors errors,
    final int page, final boolean finish) {
    if (finish) {
      this.getValidator().validate(command, errors);
      return;
    }
    final Book book = (Book) command;
    final BookValidator bookValidator = (BookValidator) getValidator();
    // errors.setNestedPath("book");

    switch (page) {
      case 0:
        bookValidator.validateAuthor(book, errors);
        break;
      case 1:
        bookValidator.validateTitle(book, errors);
        break;
      case 2:
        bookValidator.validateDescription(book, errors);
        break;
      case 3:
        bookValidator.validateAvailability(book, errors);
        break;
      case 4:
        bookValidator.validateCount(book, errors);
        break;
    }
    // errors.setNestedPath("");
  }

}
