package com.example.phonebookwebapp.controllers;

import com.example.phonebookwebapp.models.Contact;
import com.example.phonebookwebapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping("/add")
    public String addContact(@RequestBody Contact contact){
        if(contact.getPhoneNum().size()==0) return "Add Mobile Number";
        return contactService.addContact(contact);
    }
    @DeleteMapping("/remove")
    public String removeContact(@RequestParam String mobileNum){
        return contactService.removeContact(mobileNum);
    }

    @PatchMapping("/update")
    public String updateContact(@RequestParam String name,@RequestParam String phoneNum){
        contactService.updateContact(name,phoneNum);
        return "OK";
    }
    @GetMapping("/byName")
    public List<Contact> findByName(@RequestParam String name){
        return contactService.serachContactByName(name);
    }
}
