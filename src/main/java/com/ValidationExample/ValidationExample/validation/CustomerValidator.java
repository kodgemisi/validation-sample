package com.ValidationExample.ValidationExample.validation;

import com.ValidationExample.ValidationExample.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created on March, 2018
 *
 * @author yagiz
 */
@Component
public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		if (customer.getFirstName().equalsIgnoreCase("noname")) {
			errors.rejectValue("firstName", null, "First Name can not be NONAME");
		}
	}
}
