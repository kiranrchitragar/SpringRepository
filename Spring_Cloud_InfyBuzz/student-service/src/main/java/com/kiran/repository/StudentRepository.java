package com.kiran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
