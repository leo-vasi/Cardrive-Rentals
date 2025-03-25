package com.leo.cardriverentals.service;

import com.leo.cardriverentals.model.Contact;
import com.leo.cardriverentals.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService (ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById (Long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact (Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact (Long id,Contact contact) {
        Contact existingContact = contactRepository.findById(id).orElseThrow(()-> new RuntimeException("No Contact Found"));
        existingContact.setUser(contact.getUser());
        existingContact.setPhone(contact.getPhone());
        existingContact.setEmail(contact.getEmail());
        existingContact.setRecoveryEmail(contact.getRecoveryEmail());
        return contactRepository.save(existingContact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
