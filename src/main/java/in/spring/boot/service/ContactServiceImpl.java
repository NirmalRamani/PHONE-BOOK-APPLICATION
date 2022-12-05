package in.spring.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.boot.binding.ContactForm;
import in.spring.boot.entity.Contact;
import in.spring.boot.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@Override
	public String saveContact(ContactForm form)//received binding object as parameter
	{
		// create object for contact class
		Contact entity=new Contact();
		//copy the data from binding object to entity object
		BeanUtils.copyProperties(form, entity);
		entity.setActiveSw("Y");
		//save the data 
		entity=contactRepo.save(entity);
		
		if(entity.getContactId()!=null)
		{
			return "Contact Saved";
		}
			
	return "Contact Not Saved";
	}

	@Override
	public List<ContactForm> viewContact() {
		// TODO Auto-generated method stub
		ArrayList<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();
		
		//we can't copy one list object to another list object directly
		for(Contact entity:findAll)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContactForm(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent())
		{
			Contact entity = findById.get();
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		// TODO Auto-generated method stub
		contactRepo.deleteById(contactId);
		
		//getting latest data from table and returning
		ArrayList<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();
		
		//we can't copy one list object to another list object directly
		for(Contact entity:findAll)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
		
		//return viewContact();
	}

}
