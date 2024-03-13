package com.example.ecomerce.service;

import com.example.ecomerce.entity.RoomCategoryEntity;
import com.example.ecomerce.repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomCategoryService {

    @Autowired
    RoomCategoryRepository roomcategoryRepository;

    public void save(RoomCategoryEntity roomCategory) {
        roomcategoryRepository.save(roomCategory);
    }

    public List<RoomCategoryEntity> findAll() {
        return (List<RoomCategoryEntity>) roomcategoryRepository.findAll();
    }

    public RoomCategoryEntity findById(int id) {
        return roomcategoryRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        roomcategoryRepository.deleteById(id);
    }

    public List<RoomCategoryEntity> searchByName(String search) {
        return roomcategoryRepository.searchByName(search);
    }

}
