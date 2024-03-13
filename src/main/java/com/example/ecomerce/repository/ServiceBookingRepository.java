package com.example.ecomerce.repository;

import com.example.ecomerce.entity.ServiceBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBookingEntity, Integer> {

    @Query(value = "select *  from service_booking  join  booking_detail on  booking_detail.id = service_booking.booking_detail_id 	where booking_detail.id = :id", nativeQuery = true)
    public List<ServiceBookingEntity> findByBookingDetailId(@Param(value = "id") int id);

    @Query(value = "Select * from service_booking where booking_detail_id = :bdId and service_id = :svId", nativeQuery = true)
    public Optional<ServiceBookingEntity> findByBookingDetailAndService(@Param(value = "bdId") int bdId, @Param(value = "svId") int svId);
}
