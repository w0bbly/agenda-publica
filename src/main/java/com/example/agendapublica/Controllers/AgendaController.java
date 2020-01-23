package com.example.agendapublica.Controllers;

import com.example.agendapublica.DTO.ContactDTO;
import com.example.agendapublica.Services.AgendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/agenda")
public class AgendaController {

    @Autowired
    private AgendaServices agendaServices;

    @GetMapping(path = "/contacts/all")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> contacts = agendaServices.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping(path = "/contacts/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        ContactDTO contact = agendaServices.getContactById(id);

        if(contact != null)
            return ResponseEntity.ok(contact);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping(path = "/contacts")
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        ContactDTO contact = agendaServices.createContact(contactDTO);
        if(contact == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.ok(contact);
    }

    @PutMapping(path = "/contacts/{id}")
    public ResponseEntity<ContactDTO> editContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        ContactDTO contact = agendaServices.editContact(id, contactDTO);
        if(contact == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return ResponseEntity.ok(contact);
    }

    @DeleteMapping(path = "/contacts/{id}")
    public ResponseEntity<String> deleteContactById(@PathVariable Long id) {
        String response = agendaServices.deleteContactById(id);

        if(response.contains("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } else
            return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/contacts/all")
    public ResponseEntity<String> deleteAllContacts() {
        String response = agendaServices.deleteAllContacts();

        if(response.contains("Error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } else
            return ResponseEntity.ok(response);
    }
}
