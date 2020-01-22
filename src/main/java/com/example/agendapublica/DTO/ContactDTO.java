package com.example.agendapublica.DTO;

import com.example.agendapublica.Entities.TelephoneNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ContactDTO {
    private AddressDTO address;
    private List<TelephoneNumberDTO> telephoneNumbers;

    public ContactDTO() {
    }
}
