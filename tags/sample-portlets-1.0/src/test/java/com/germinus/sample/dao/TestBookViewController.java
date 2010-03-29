package com.germinus.sample.dao;

import java.util.Map;

import org.springframework.mock.web.portlet.MockRenderRequest;
import org.springframework.mock.web.portlet.MockRenderResponse;
import com.germinus.sample.model.Book;
import com.germinus.sample.controller.BookViewController;
import org.springframework.web.portlet.ModelAndView;

public class TestBookViewController extends TestCase {

    public void testBookViewController() throws Exception {

        BookViewController controller = (BookViewController)booksPortletContext.getBean("bookViewController");

    	MockRenderRequest request = new MockRenderRequest();
    	MockRenderResponse response = new MockRenderResponse();

    	request.addParameter("book", "1");
    	
		ModelAndView mav = controller.handleRenderRequest(request, response);
		assertNotNull(mav);
		
		logger.info("view: " + mav.getViewName());
		
		Map model = mav.getModel();

		assertTrue(model.containsKey("book"));
		Book book = (Book)model.get("book");

		logger.info("book.author: " + book.getAuthor());
		logger.info("book.title: " + book.getTitle());
		logger.info("book.description: " + book.getDescription());
		logger.info("book.count: " + book.getCount());
        
    }
    
}
