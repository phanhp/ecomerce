package com.example.ecomerce.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "convenient")
public class ConvenientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "convenient")
    private Set<RoomCategoryEntity> roomCategory;

    public ConvenientEntity() {
        // TODO Auto-generated constructor stub
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RoomCategoryEntity> getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(Set<RoomCategoryEntity> roomCategory) {
        this.roomCategory = roomCategory;
    }


}

