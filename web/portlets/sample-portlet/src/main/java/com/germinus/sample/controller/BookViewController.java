package com.germinus.sample.controller;


import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;
import org.springframework.web.portlet.ModelAndView;

import com.germinus.sample.web.BookService;

public class BookViewController extends AbstractController implements InitializingBean {

    private BookService bookService;
    
    public void afterPropertiesSet() throws Exception {
        if (this.bookService == null)
            throw new IllegalArgumentException("A BookService is required");
    }
    
	@Override
  public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
	    // get the id and display it
	    Integer id = new Integer(request.getParameter("book"));
        return new ModelAndView("bookView", "book", bookService.getBook(id));
	}

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}