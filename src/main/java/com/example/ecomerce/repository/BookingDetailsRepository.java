package com.example.ecomerce.repository;

import com.example.ecomerce.entity.BookingDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetailEntity, Integer> {
    @Query(value = "select *  from booking_detail  join booking on booking.id = booking_detail.booking_id	where booking.id = :id", nativeQuery = true)
    public List<BookingDetailEntity> findByBookingId(@Param(value = "id") int id);
}
