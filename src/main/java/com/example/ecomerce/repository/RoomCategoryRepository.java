package com.example.ecomerce.repository;

import com.example.ecomerce.entity.RoomCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomCategoryRepository extends JpaRepository<RoomCategoryEntity, Integer> {

    @Query(value = "select * from room_category "
            + "where concat(id, bedInfo, capacity, createDate, description, name, price, size, status) like %?1%", nativeQuery = true)
    public List<RoomCategoryEntity> searchByName(String search);

}
