package com.example.agendapublica.Repository;

import com.example.agendapublica.Config.EntityMapper;
import com.example.agendapublica.DTO.TelephoneNumberDTO;
import com.example.agendapublica.Entities.TelephoneNumber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NumberMapping extends EntityMapper<TelephoneNumberDTO, TelephoneNumber> {
}
