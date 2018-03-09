package com.ValidationExample.ValidationExample.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Created on March, 2018
 *
 * @author yagiz
 */
@Data
public class Customer {
	//Bos birakilamaz Annotation'u
	@NotEmpty(message = "Isim bos bırakılamaz.")
	private String firstName;

	//Bos birakilamaz Annotationu
	@NotEmpty(message = "Soyisim bos birakilamaz.")
	private String surname;

	//Min value Annotation'u
	@Min(value = 18, message = "18 yasindan kucuk olamaz")
	private int age;

	//Mail check Annotation'u
	@Email(message = "Hatali email")
	private String email;

	//Regex Annotation'u
	@Pattern(regexp ="[0-9\\s]{12}", message = "Gecersiz telefon numarasi")
	private String phone;
}
