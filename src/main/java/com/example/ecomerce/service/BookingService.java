package com.example.ecomerce.service;

import com.example.ecomerce.entity.BookingEntity;
import com.example.ecomerce.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public void save(BookingEntity booking) {
        bookingRepository.save(booking);
    }

    public List<BookingEntity> findAll() {
        return (List<BookingEntity>) bookingRepository.findAll();
    }


    public BookingEntity findById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<BookingEntity> searchByName(String search) {
        return bookingRepository.searchByName(search);
    }

}
