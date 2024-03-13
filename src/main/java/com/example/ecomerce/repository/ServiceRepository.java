package com.example.ecomerce.repository;

import com.example.ecomerce.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
    @Query(value ="SELECT service.name FROM service "
            + "Join service_booking on service.id = service_booking.service_id "
            + "JOIN booking_detail ON booking_detail.id = service_booking.booking_detail_id "
            + "JOIN  booking ON booking.id = booking_detail.booking_id  "
            + "JOIN room ON booking_detail.room_id = room.id  "
            + "WHERE room.id = :id",nativeQuery = true)
    public List<ServiceEntity> findServiceByRoom(@Param("id")int id);

    @Query("select s from ServiceEntity s where s.name like %:keyword% ")
    public List<ServiceEntity> searchByName(@Param("keyword") String keyword);

}
