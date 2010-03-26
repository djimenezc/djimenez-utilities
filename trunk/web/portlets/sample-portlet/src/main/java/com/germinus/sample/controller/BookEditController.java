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
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.mvc.SimpleFormController;
import org.springframework.web.portlet.ModelAndView;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;

public class BookEditController extends SimpleFormController implements InitializingBean {

    private BookService bookService;
    
    public void afterPropertiesSet() throws Exception {
        if (this.bookService == null)
            throw new IllegalArgumentException("A BookService is required");
    }

	@Override
  public void onSubmitAction(ActionRequest request, ActionResponse response,
			Object command,	BindException errors) throws Exception {
		
		Book book = (Book) command;
	    Integer key;

    	try {
    	    key = new Integer(request.getParameter("book"));
    	} catch (NumberFormatException ex) {
    	    key = null;
    	}
		
		if (key == null) {
			bookService.addBook(book);
		} else {
			bookService.saveBook(book);
		}

		response.setRenderParameter("action","books");
	}
	
    @Override
    protected Object formBackingObject(PortletRequest request)
    		throws Exception {

    	Book book;

    	try {
    	    Integer key = new Integer(request.getParameter("book"));
    	    book = bookService.getBook(key);
    	} catch (NumberFormatException ex) {
        	book = new Book();
    	}
    	
		return book;
	}
    
	@Override
  protected void initBinder(PortletRequest request, PortletRequestDataBinder binder)
			throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, null, new	CustomDateEditor(dateFormat, true));
	    binder.setAllowedFields(new String[] {"author","title","description","availability","count"});
	}

	@Override
  protected ModelAndView renderInvalidSubmit(RenderRequest request, RenderResponse response)
			throws Exception {
	    return null;
	}
	
	@Override
  protected void handleInvalidSubmit(ActionRequest request, ActionResponse response)
			throws Exception {
		response.setRenderParameter("action","books");
	}

	public void setBookService(BookService bookService) {
	    this.bookService = bookService;
	}
}

