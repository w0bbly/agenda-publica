package com.example.agendapublica.Services;

import com.example.agendapublica.DTO.ContactDTO;
import com.example.agendapublica.Entities.Address;
import com.example.agendapublica.Entities.Contact;
import com.example.agendapublica.Entities.TelephoneNumber;
import com.example.agendapublica.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendaServices {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private NumberRepository numberRepository;
    @Autowired
    private ContactMapping contactMapping;
    @Autowired
    private AddressMapping addressMapping;
    @Autowired
    private NumberMapping numberMapping;

    public AgendaServices() {

    }

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contactMapping.toDto(contacts);
    }

    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(contactMapping::toDto).orElse(null);
    }

    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        Address address = new Address();
        List<TelephoneNumber> telephoneNumbers = new ArrayList<>();

        address = addressMapping.toEntity(contactDTO.getAddress());
        telephoneNumbers = numberMapping.toEntity(contactDTO.getTelephoneNumbers());

        contact.setAddress(address);
        contact.setTelephoneNumbers(telephoneNumbers);

        contactRepository.save(contact);
        return contactMapping.toDto(contact);
    }

    public ContactDTO editContact(Long id, ContactDTO contactDTO) {
        Optional<Contact> contact = contactRepository.findById(id);
        AtomicInteger integer = new AtomicInteger(0);

        if(contact.isPresent()) {
            contact.get().getAddress().setAddress(contactDTO.getAddress().getAddress());
            if(contactDTO.getTelephoneNumbers().size() <= contact.get().getTelephoneNumbers().size() && contactDTO.getTelephoneNumbers().size() != 0) {
                contactDTO.getTelephoneNumbers().forEach(telephoneNumberDTO -> {
                    contact.get().getTelephoneNumbers().get(integer.get()).setNumber(telephoneNumberDTO.getNumber());
                    integer.set(integer.get()+1);
                });
            } else {
                int nElements = contact.get().getTelephoneNumbers().size();
                contactDTO.getTelephoneNumbers().forEach(telephoneNumberDTO -> {
                    if((integer.get()+1) <= nElements) {
                        contact.get().getTelephoneNumbers().get(integer.get()).setNumber(telephoneNumberDTO.getNumber());
                    } else {
                        contact.get().getTelephoneNumbers().add(numberMapping.toEntity(telephoneNumberDTO));
                    }
                    integer.set(integer.get()+1);
                });
            }

            contactRepository.save(contact.get());

            return contactMapping.toDto(contact.get());
        }

        return null;
    }

    public String deleteContactById(Long id) {
        return "";
    }

    public String deleteAllContacts() {
        return "";
    }
}
