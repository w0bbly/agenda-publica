package com.example.agendapublica.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TelephoneNumberDTO {
    private Long id;
    private Long number;

    public TelephoneNumberDTO() {
    }
}
