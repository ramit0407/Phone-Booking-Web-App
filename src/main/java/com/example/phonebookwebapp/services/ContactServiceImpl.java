package com.example.phonebookwebapp.services;

import com.example.phonebookwebapp.models.Contact;
import com.example.phonebookwebapp.repository.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public String addContact(Contact contact) {
        List<String> contacts = contact.getPhoneNum();
        if(contactRepository.findByPhoneNumIn(contacts).isPresent()) {
            return "Mobile Number is already present.";
        }
        contactRepository.save(contact);
        return "OK";
    }

    @Override
    public String removeContact(String mobileNum) {
        contactRepository.deleteByPhoneNumContains(mobileNum);
        return "Deleted...";
    }

    @Override
    public String updateContact(String name,String phoneNum) {
        contactRepository.updateNameByMobile(name,phoneNum);
        return "OK";
    }

    @Override
    public List<Contact> serachContactByName(String name) {
        return contactRepository.searchContactByNameContainsIgnoreCase(name);
    }
}
