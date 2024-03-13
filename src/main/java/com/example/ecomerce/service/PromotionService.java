package com.example.ecomerce.service;

import com.example.ecomerce.entity.PromotionEntity;
import com.example.ecomerce.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    PromotionRepository promotionRepository;


    public void save(PromotionEntity promotion) {
        promotionRepository.save(promotion);
    }

    public List<PromotionEntity> findAll() {
        return (List<PromotionEntity>) promotionRepository.findAll();
    }

    public PromotionEntity findById(int id) {
        return promotionRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        promotionRepository.deleteById(id);
    }

    public List<PromotionEntity> searchByName(String search) {
        return promotionRepository.searchByName(search);
    }

}
