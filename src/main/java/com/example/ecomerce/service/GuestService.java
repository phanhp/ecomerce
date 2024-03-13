package com.example.ecomerce.service;

import com.example.ecomerce.entity.GuestEntity;
import com.example.ecomerce.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    GuestRepository guestRepository;

    public void save(GuestEntity guest) {
        guestRepository.save(guest);
    }

    public List<GuestEntity> findAll() {
        return (List<GuestEntity>) guestRepository.findAll();
    }

    public List<GuestEntity> findByBookingDetailId(int id) {
        return guestRepository.findByBookingDetailId(id);
    }

    public Optional<GuestEntity> findById(int id) {
        return guestRepository.findById(id);
    }

    public void deleteById(int id) {
        guestRepository.deleteById(id);
    }

}
