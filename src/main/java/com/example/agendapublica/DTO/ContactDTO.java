package com.example.agendapublica.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ContactDTO {
    private Long id;
    private AddressDTO address;
    private List<TelephoneNumberDTO> telephoneNumbers;

    public ContactDTO() {
    }
}
