package rain.web;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/*
 * 
 * TODO 
 * 
 * Define a class named EnquiryCommand that:
 * 
 * 	a. Implements the Serializable interface
 *  b. Has the following properties, all of type String
 *     
 *     1  name
 *     2  email
 *     3  telephone
 *     4  enquiryDetails
 * 
 * 
 * Add the NotEmpty JSR 303 validation rule to the name,
 * email and enquiryDetails fields. Choose a suitable
 * message to display in the event of validation failure 
 * 
 */

public class EnquiryCommand implements Serializable {
	@NotEmpty(message="Field is required")
	String name;
	@NotEmpty(message="Email addr is required")
	@Email(message="Doesn't look like any email *I* ever saw")
	String email;
	@NotEmpty(message="Enquiry is required")
	String enquiryDetails;
	String telephone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnquiryDetails() {
		return enquiryDetails;
	}
	public void setEnquiryDetails(String enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
