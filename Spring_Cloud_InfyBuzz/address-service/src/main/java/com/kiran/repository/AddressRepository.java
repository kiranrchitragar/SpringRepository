package com.kiran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
