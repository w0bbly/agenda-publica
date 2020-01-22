package com.example.agendapublica.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String address;

    public Address() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id.equals(address1.id) &&
                address.equals(address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }
}
