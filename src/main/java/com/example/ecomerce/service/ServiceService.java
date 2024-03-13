package com.example.ecomerce.service;

import com.example.ecomerce.entity.ServiceEntity;
import com.example.ecomerce.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public void save(ServiceEntity service) {
        service.setCreateDate(LocalDate.now());
        serviceRepository.save(service);
    }

    public List<ServiceEntity> findAll() {
        return (List<ServiceEntity>) serviceRepository.findAll();
    }

    public ServiceEntity findById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }


    public List<ServiceEntity> findServiceByRoom(int id) {

        return serviceRepository.findServiceByRoom(id);
    }

    public List<ServiceEntity> searchByName(String search) {
        return serviceRepository.searchByName(search);
    }
}
