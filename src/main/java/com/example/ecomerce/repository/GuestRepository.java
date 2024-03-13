package com.example.ecomerce.repository;

import com.example.ecomerce.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {


    @Query(value = "select *  from guest join  booking_detail on  booking_detail.id = guest.booking_detail_id 	where booking_detail.id = :id", nativeQuery = true)
    public List<GuestEntity> findByBookingDetailId(@Param(value = "id") int id);
}
