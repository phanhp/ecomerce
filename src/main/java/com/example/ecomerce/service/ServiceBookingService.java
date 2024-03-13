package com.example.ecomerce.service;

import com.example.ecomerce.entity.ServiceBookingEntity;
import com.example.ecomerce.repository.ServiceBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBookingService {

    @Autowired
    ServiceBookingRepository serviceBookingRepository;

    public void save(ServiceBookingEntity serviceBooking) {
        serviceBookingRepository.save(serviceBooking);
    }

    public List<ServiceBookingEntity> findAll() {
        return (List<ServiceBookingEntity>) serviceBookingRepository.findAll();
    }

    public List<ServiceBookingEntity> findByBookingDetailId(int id) {
        return serviceBookingRepository.findByBookingDetailId(id);
    }

    public Optional<ServiceBookingEntity> findById(int id) {
        return serviceBookingRepository.findById(id);
    }

    public void deleteById(int id) {
        serviceBookingRepository.deleteById(id);
    }

    public Optional<ServiceBookingEntity> findByBookingDetailAndService(int bdId, int serviceId) {
        return serviceBookingRepository.findByBookingDetailAndService(bdId, serviceId);
    }
}
