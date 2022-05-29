package com.example.employe.repository;

import com.example.employe.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer> {
    List<Employe> findAllByStatus(Boolean status);

}
