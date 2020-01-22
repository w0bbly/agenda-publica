package com.example.agendapublica.Repository;

import com.example.agendapublica.Entities.TelephoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<TelephoneNumber, Long> {
}
