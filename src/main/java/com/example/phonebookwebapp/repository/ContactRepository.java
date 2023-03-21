package com.example.phonebookwebapp.repository;


import com.example.phonebookwebapp.models.Contact;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ContactRepository extends JpaRepository<Contact,Integer> {

    public List<Contact> findByName(String name);
    public Optional<Contact> findByPhoneNumIn(List<String> phoneNum);

    public void deleteByPhoneNumContains(String phoneNum);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Contact c set c.name = :name where :mobile member of c.phoneNum")
    public void updateNameByMobile(@Param("name") String name,@Param("mobile") String mobile);

    public List<Contact> searchContactByNameContainsIgnoreCase(String name);
}
