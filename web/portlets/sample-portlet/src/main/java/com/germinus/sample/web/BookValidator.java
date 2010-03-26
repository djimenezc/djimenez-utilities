package com.germinus.sample.web;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.germinus.sample.model.Book;

public class BookValidator implements Validator {

    public boolean supports(Class clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        Book book = (Book)obj;
        validateAuthor(book, errors);
        validateTitle(book, errors);
        validateDescription(book, errors);
        validateAvailability(book, errors);
        validateCount(book, errors);
    }

	public void validateAuthor(Book book, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "author", "AUTHOR_REQUIRED", "Author is required.");
	}

	public void validateTitle(Book book, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "TITLE_REQUIRED", "Title is required.");
	}

	public void validateDescription(Book book, Errors errors) {
	}
    
	public void validateAvailability(Book book, Errors errors) {
	}
    
	public void validateCount(Book book, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "count", "COUNT_REQUIRED", "Current count is required.");
	}
    
}
