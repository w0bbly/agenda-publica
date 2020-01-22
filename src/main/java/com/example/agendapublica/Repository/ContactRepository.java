package com.example.agendapublica.Repository;

import com.example.agendapublica.Entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
