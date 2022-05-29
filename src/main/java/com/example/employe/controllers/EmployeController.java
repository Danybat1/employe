package com.example.employe.controllers;

import com.example.employe.entities.Employe;
import com.example.employe.services.EmployeService;
import com.example.employe.utils.HttpDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employe")
public class EmployeController {

    @Autowired
    EmployeService service;

    private final Logger logger = LoggerFactory.getLogger(EmployeController.class);

    @GetMapping
    public HttpDataResponse getAll() {
        HttpDataResponse response = new HttpDataResponse();
        try {
            List list = service.findAll();
            if (list.size() > 1) {
                response.setResponse(list);
            } else {
                logger.error("Ressources introuvables");
                throw new Exception("Ressources introuvables");
            }
        } catch (Exception e) {
            response.setStatus("KO");
            response.setError(e.getMessage());
        } finally {
            return response;
        }
    }
    @PostMapping
    public HttpDataResponse save(@RequestBody Employe employe) {
        HttpDataResponse response = new HttpDataResponse();
        try {

            try {
                if (employe.getNom().equals("")) {
                    throw new Exception("Nom can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Nom can't be null");
            }
            try {
                if (employe.getAdresse().equals("")) {
                    throw new Exception("Adresse can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Adresse can't be null");
            }
            try {
                if (employe.getPhone().equals("")) {
                    throw new Exception("Phone can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Phone can't be null");
            }
            employe=service.save(employe);
            response.setResponse(employe);
            return  response;
        } catch (Exception e) {
            response.setStatus("KO");
            response.setError(e.getMessage());
        } finally {
            return response;
        }
    }
    @PutMapping("/{id}")
    public HttpDataResponse update(@PathVariable Integer id,@RequestBody Employe employe) {
        HttpDataResponse response = new HttpDataResponse();
        try {
            try {
                if (employe.getId() <= 0) {
                    throw new Exception("Id can't be more less than 0");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Id can't be null");
            }
            try {
                if (employe.getNom().equals("")) {
                    throw new Exception("Nom can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Nom can't be null");
            }
            try {
                if (employe.getAdresse().equals("")) {
                    throw new Exception("Adresse can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Adresse can't be null");
            }
            try {
                if (employe.getPhone().equals("")) {
                    throw new Exception("Phone can't be Empty");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Phone can't be null");
            }
            employe=service.update(employe,id);
            response.setResponse(employe);
            return  response;
        } catch (Exception e) {
            response.setStatus("KO");
            response.setError(e.getMessage());
        } finally {
            return response;
        }
    }
    @DeleteMapping("/{id}")
    public HttpDataResponse delete(@PathVariable Integer id) {
        HttpDataResponse response = new HttpDataResponse();
        try {
            try {
                if (id <= 0) {
                    throw new Exception("Id can't be more less than 0");
                }
            }
            catch (NullPointerException e2) {
                throw new Exception("Id can't be null");
            }
            response.setResponse(service.delete(id));
            return response;
        } catch (Exception e) {
            response.setStatus("KO");
            response.setError(e.getMessage());
        } finally {
            return response;
        }
    }

}
