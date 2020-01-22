package com.example.agendapublica.Repository;

import com.example.agendapublica.Config.EntityMapper;
import com.example.agendapublica.DTO.AddressDTO;
import com.example.agendapublica.Entities.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapping extends EntityMapper<AddressDTO, Address> {
}
