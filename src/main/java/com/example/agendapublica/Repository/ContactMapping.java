package com.example.agendapublica.Repository;

import com.example.agendapublica.Config.EntityMapper;
import com.example.agendapublica.DTO.ContactDTO;
import com.example.agendapublica.Entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapping extends EntityMapper<ContactDTO, Contact> {
}
