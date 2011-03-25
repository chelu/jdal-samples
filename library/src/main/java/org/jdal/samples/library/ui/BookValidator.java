package org.jdal.samples.library.ui;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return BookValidator.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required",
				new Object[] {"title"});
		ValidationUtils.rejectIfEmpty(errors, "author", "field.required", new Object[] {"author"});
		
	}
	
}
