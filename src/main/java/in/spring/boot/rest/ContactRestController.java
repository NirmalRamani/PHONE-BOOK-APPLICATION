package in.spring.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.spring.boot.binding.ContactForm;
import in.spring.boot.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form)
	{
		System.out.println(form);
		String status = service.saveContact(form);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts()
	{
		return service.viewContact();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId)
	{
		return service.editContactForm(contactId);
	}
	
	@GetMapping("/delete/{contactId}")
	public List<ContactForm> delContact(@PathVariable Integer contactId)
	{
		return service.deleteContact(contactId);
	}
}
