package com.example.phonebookwebapp.services;

import com.example.phonebookwebapp.models.Contact;

import java.util.List;


public interface ContactService {
    String addContact(Contact contact);
    String removeContact(String mobileNum);
    String updateContact(String name,String phoneNum);
    List<Contact> serachContactByName(String name);
}
