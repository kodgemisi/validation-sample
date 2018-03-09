package com.ValidationExample.ValidationExample;
import com.ValidationExample.ValidationExample.model.Customer;
import com.ValidationExample.ValidationExample.validation.CustomerValidator;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
/**
 * Created on March, 2018
 *
 * @author yagiz
 */
@Controller
@Log
public class CustomerController {
	@Autowired
	CustomerValidator customerValidator;
	@InitBinder
	protected void initBinder(final WebDataBinder binder){
		binder.addValidators(customerValidator);
	}
	@GetMapping("/")
	public String getCustomerCreatePage(Model model){
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}
	@PostMapping("/")
	public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "addCustomer";
		}
		log.info("Customer Created");
		return "addCustomer";
	}
}