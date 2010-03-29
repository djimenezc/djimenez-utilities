package com.germinus.sample.controller;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.portlet.mvc.AbstractController;
import org.springframework.web.portlet.ModelAndView;

import com.germinus.sample.web.BookService;

public class BooksController extends AbstractController implements InitializingBean {

    private BookService bookService;
    
    public void afterPropertiesSet() throws Exception {
        if (this.bookService == null)
            throw new IllegalArgumentException("A BookService is required");
    }
    
	public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response) throws Exception {
    
		Map model = new HashMap();
		model.put("books", bookService.getAllBooks());
        return new ModelAndView("booksView", "model", model);
	}

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}