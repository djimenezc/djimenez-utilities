package com.germinus.sample.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;


public class BookIncrementController extends AbstractController implements InitializingBean {

    private BookService bookService;
    
    public void afterPropertiesSet() throws Exception {
        if (this.bookService == null)
            throw new IllegalArgumentException("A BookService is required");
    }

	@Override
  public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {
	    // get the id and delete it
	    Integer id = new Integer(request.getParameter("book"));
	    Integer increment = new Integer(request.getParameter("increment"));
		Book book = bookService.getBook(id);
		book.incrementCount(increment);
        bookService.saveBook(book);
		// change action parameter to go to default view
		response.setRenderParameter("action","books");
	}

	public void setBookService(BookService bookService) {
	    this.bookService = bookService;
	}
}