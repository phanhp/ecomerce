package com.example.ecomerce.repository;

import com.example.ecomerce.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Query("select b from BookingEntity b where b.fullName like %:keyword% ")
    public List<BookingEntity> searchByName(@Param("keyword") String keyword);
}
