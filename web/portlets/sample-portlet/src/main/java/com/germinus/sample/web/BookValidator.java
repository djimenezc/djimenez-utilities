package com.germinus.sample.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.germinus.sample.model.Book;

public class BookValidator implements Validator {

  @SuppressWarnings("unchecked")
  public boolean supports(final Class clazz) {
    return Book.class.isAssignableFrom(clazz);
  }

  public void validate(final Object obj, final Errors errors) {
    final Book book = (Book) obj;
    validateAuthor(book, errors);
    validateTitle(book, errors);
    validateDescription(book, errors);
    validateAvailability(book, errors);
    validateCount(book, errors);
  }

  public void validateAuthor(final Book book, final Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "author", "AUTHOR_REQUIRED",
      "Author is required.");
  }

  public void validateAvailability(final Book book, final Errors errors) {
  }

  public void validateCount(final Book book, final Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "count", "COUNT_REQUIRED",
      "Current count is required.");
  }

  public void validateDescription(final Book book, final Errors errors) {
  }

  public void validateTitle(final Book book, final Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "title", "TITLE_REQUIRED",
      "Title is required.");
  }

}
