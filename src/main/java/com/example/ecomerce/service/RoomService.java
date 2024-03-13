package com.example.ecomerce.service;

import com.example.ecomerce.entity.RoomEntity;
import com.example.ecomerce.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public void save(RoomEntity room) {
        roomRepository.save(room);
    }

    public List<RoomEntity> findAll() {
        return (List<RoomEntity>) roomRepository.findAll();
    }

    public List<RoomEntity> findRoomByBookingId(int id) {
        return roomRepository.findRoomByBookingId(id);
    }

}
