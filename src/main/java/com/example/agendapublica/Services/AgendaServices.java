package com.example.agendapublica.Services;

import com.example.agendapublica.DTO.ContactDTO;
import com.example.agendapublica.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaServices {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private NumberRepository numberRepository;

    private AddressMapping addressMapping;
    private ContactMapping contactMapping;
    private NumberMapping numberMapping;

    public List<ContactDTO> getAllContacts() {
        return new ArrayList<>();
    }

    public ContactDTO getContactById(Long id) {
        return new ContactDTO();
    }

    public ContactDTO createContact(ContactDTO contactDTO) {
        return new ContactDTO();
    }

    public ContactDTO editContact(Long id, ContactDTO contactDTO) {
        return new ContactDTO();
    }

    public String deleteContactById(Long id) {
        return "";
    }
}
