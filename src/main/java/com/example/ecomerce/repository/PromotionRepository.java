package com.example.ecomerce.repository;

import com.example.ecomerce.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {

    @Query("select p from PromotionEntity p where p.name like %:keyword% ")
    public List<PromotionEntity> searchByName(@Param("keyword") String keyword);

}
