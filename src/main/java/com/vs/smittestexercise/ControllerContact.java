package com.vs.smittestexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ControllerContact {
    @Autowired
    RepositoryContact repositoryContact;

    @GetMapping("/contacts")
    public List<ModelContact> getAllContacts() {

        List<ModelContact> list = new ArrayList<>();
        Iterable<ModelContact> customers = repositoryContact.findAll();

        customers.forEach(list::add);
        return list;
    }

    @PostMapping("/contacts/create")
    public ModelContact createContact(@Valid @RequestBody ModelContact contact) {
        return repositoryContact.save(contact);
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<ModelContact> getContact(@PathVariable("id") Long id) {

        Optional<ModelContact> contactData = repositoryContact.findById(id);
        if (contactData.isPresent()) {
            return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<ModelContact> updateContact(@PathVariable("id") Long id, @RequestBody ModelContact contact) {

        Optional<ModelContact> contactData = repositoryContact.findById(id);
        if (contactData.isPresent()) {
            ModelContact savedContact = contactData.get();
            savedContact.setContact_name(contact.getContact_name());
            savedContact.setContact_keyword(contact.getContact_keyword());
            savedContact.setContact_phonenumber(contact.getContact_phonenumber());

            ModelContact updatedContact = repositoryContact.save(savedContact);
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long id) {

        try {
            repositoryContact.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete.", HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>("Contact has been deleted.", HttpStatus.OK);
    }
}
