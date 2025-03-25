package com.leo.cardriverentals.controller;

import com.leo.cardriverentals.model.Contact;
import com.leo.cardriverentals.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController (ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(contacts);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById (@PathVariable Long id) {
        Optional<Contact> contact = contactService.getContactById(id);
        if (contact.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(contact.get());
        }
    }

    @PostMapping
    public ResponseEntity<Contact> createContact (@Valid @RequestBody Contact contact) {
        Contact createContact = contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createContact);
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<Contact> updateContact (@PathVariable Long id, @RequestBody Contact contact) {
        Optional<Contact> existingContact = contactService.getContactById(id);
        if (existingContact.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            Contact updatedContact = contactService.updateContact(id, contact);
            return ResponseEntity.ok(updatedContact);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteContact (@PathVariable Long id) {
        if (contactService.getContactById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            contactService.deleteContact(id);
            return ResponseEntity.noContent().build();
        }
    }
}
