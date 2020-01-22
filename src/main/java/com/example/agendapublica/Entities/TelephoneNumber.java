package com.example.agendapublica.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "telephone_number")
@Getter
@Setter
@ToString
public class TelephoneNumber {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 9)
    @NotNull
    private Long number;

    public TelephoneNumber() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return id.equals(that.id) &&
                number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}
