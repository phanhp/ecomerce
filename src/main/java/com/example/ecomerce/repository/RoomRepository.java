package com.example.ecomerce.repository;

import com.example.ecomerce.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {

    @Query(value = "select room.id, room_number, room.status, room_category_id from room  join booking_detail on  room.id = booking_detail.room_id join booking on booking.id = booking_detail.booking_id	where booking.id = :id", nativeQuery = true)
    public List<RoomEntity> findRoomByBookingId(@Param(value = "id") int id);
}
