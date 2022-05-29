package com.example.employe.services;

import com.example.employe.entities.Employe;
import com.example.employe.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    EmployeRepository repository;

    public List<Employe>findAll(){
        return  repository.findAllByStatus(true);
    }
    public Employe save(Employe employe){
        return repository.save(employe);
    }
    public Employe update(Employe employe,Integer id){
        try {
            Optional<Employe> employe1 = repository.findById(id);
          if(employe1.isPresent()){
              return repository.save(employe);
          }

        }catch (Exception e){
             e.printStackTrace();
        }
        return null;
    }
    public Boolean delete(Integer id){
        try {
            Employe employe1 = repository.findById(id).get();
            employe1.setStatus(false);
            repository.save(employe1);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }




}
