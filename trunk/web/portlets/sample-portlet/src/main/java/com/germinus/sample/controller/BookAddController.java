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
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.mvc.AbstractWizardFormController;
import org.springframework.web.portlet.ModelAndView;

import com.germinus.sample.model.Book;
import com.germinus.sample.web.BookService;
import com.germinus.sample.web.BookValidator;

class BookAddController extends AbstractWizardFormController {

    private BookService bookService;
    
    public void afterPropertiesSet() throws Exception {
        if (this.bookService == null)
            throw new IllegalArgumentException("A BookService is required");
    }

    protected void processFinish(
            ActionRequest request, ActionResponse response,
            Object command, BindException errors)
    		throws Exception {
		bookService.addBook((Book)command);
		response.setRenderParameter("action","books");
    }

    protected void processCancel(
            ActionRequest request, ActionResponse response,
            Object command, BindException errors)
            throws Exception {
		response.setRenderParameter("action","books");
    }

    protected void validatePage(
            Object command, Errors errors, int page, boolean finish) {
        if (finish) {
            this.getValidator().validate(command, errors);
            return;
        }
		Book book = (Book)command;
		BookValidator bookValidator = (BookValidator)getValidator();
		//errors.setNestedPath("book");
		switch (page) {
			case 0: bookValidator.validateAuthor(book, errors);	break;
			case 1: bookValidator.validateTitle(book, errors); break;
			case 2: bookValidator.validateDescription(book, errors); break;
			case 3: bookValidator.validateAvailability(book, errors); break;
			case 4: bookValidator.validateCount(book, errors); break;
		}
		//errors.setNestedPath("");
    }

    protected void initBinder(PortletRequest request, PortletRequestDataBinder binder)
			throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, null, new	CustomDateEditor(dateFormat, true));
	    binder.setAllowedFields(new String[] {"author","title","description","availability","count"});
    }

	protected ModelAndView renderInvalidSubmit(RenderRequest request, RenderResponse response)
			throws Exception {
	    return null;
	}

	protected void handleInvalidSubmit(ActionRequest request, ActionResponse response)
			throws Exception {
	    response.setRenderParameter("action","books");
	}

	public void setBookService(BookService bookService) {
	    this.bookService = bookService;
	}

}

