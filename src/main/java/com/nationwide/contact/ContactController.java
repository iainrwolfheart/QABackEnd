package com.nationwide.contact;

import java.util.List;
import java.util.Optional;

import com.nationwide.contact.ContactRepository;
import com.nationwide.contact.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/contactus/{id}", method = RequestMethod.GET)
	public Optional<Contact> getContactById(@PathVariable("id") String id) {
		return contactRepository.findById(id);
	}

	@RequestMapping(value = "/contactus", method = RequestMethod.POST)
	public void addNewContact(@RequestBody Contact contact){
		contactRepository.save(contact);
	}

	@RequestMapping(value = "/contactus/{id}", method = RequestMethod.PUT)
	public void updateContact(@PathVariable("id") String id, @RequestBody Contact contact){
		contact.setId(id);
		contactRepository.save(contact);

	}

	@RequestMapping(value = "/contactus/{id}", method = RequestMethod.DELETE)
	public void deleteContact(@PathVariable("id") String id) {
		contactRepository.deleteById(id);
	}
}