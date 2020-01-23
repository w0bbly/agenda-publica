package com.example.agendapublica.Services;

import com.example.agendapublica.DTO.ContactDTO;
import com.example.agendapublica.Entities.Address;
import com.example.agendapublica.Entities.Contact;
import com.example.agendapublica.Entities.TelephoneNumber;
import com.example.agendapublica.Repository.AddressMapping;
import com.example.agendapublica.Repository.ContactMapping;
import com.example.agendapublica.Repository.ContactRepository;
import com.example.agendapublica.Repository.NumberMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendaServices {
    private final ContactRepository contactRepository;
    private final ContactMapping contactMapping;
    private final AddressMapping addressMapping;
    private final NumberMapping numberMapping;

    public AgendaServices(ContactRepository contactRepository, ContactMapping contactMapping, AddressMapping addressMapping, NumberMapping numberMapping) {
        this.contactRepository = contactRepository;
        this.contactMapping = contactMapping;
        this.addressMapping = addressMapping;
        this.numberMapping = numberMapping;
    }

    /**
     * @author pims
     * @return List of all contacts saved in the database in the format of ContactDTO (Data transfer Object)
     */
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contactMapping.toDto(contacts);
    }

    /**
     * @author pims
     * @param id - id of a Contact
     * @return The contact saved with the id, passed as param, in the database in the format of ContactDTO (Data transfer Object)
     */
    public ContactDTO getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(contactMapping::toDto).orElse(null);
    }

    /**
     * @author pims
     * @param contactDTO - Object of type ContactDTO
     * @return The contact created in the database in the format of ContactDTO (Data transfer Object)
     */
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

    /**
     * @author pims
     * @param id - id of a Contact
     * @param contactDTO - Object of type ContactDTO
     * @return The contact edited in the format of ContactDTO (Data transfer Object)
     */
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

    /**
     * @author pims
     * @param id - id of a Contact
     * @return A message informing of success or error in the deletion of the Contact
     */
    public String deleteContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);

        if(contact.isPresent()) {
            contactRepository.delete(contact.get());
            return "Contact deleted with success!";
        } else {
            return "Error while deleting contact";
        }
    }

    /**
     * @author pims
     * @return A message informing of success or error in the deletion of all the Contacts
     */
    public String deleteAllContacts() {
        contactRepository.deleteAll();
        return "All contacts deleted!";
    }
}
