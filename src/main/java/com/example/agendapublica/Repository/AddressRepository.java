package com.example.agendapublica.Repository;

import com.example.agendapublica.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
