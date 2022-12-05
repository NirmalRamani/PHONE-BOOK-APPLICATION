package in.spring.boot.service;

import java.util.List;

import in.spring.boot.binding.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm form);
	
	public List<ContactForm> viewContact();
	
	public ContactForm 
	editContactForm(Integer contactId);
	
	public List<ContactForm> 
	deleteContact(Integer contactId);
}
