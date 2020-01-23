package com.example.agendapublica.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
    private Long id;
    private String address;

    public AddressDTO() {
    }
}
