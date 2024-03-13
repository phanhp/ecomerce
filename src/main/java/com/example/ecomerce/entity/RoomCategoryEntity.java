package com.example.ecomerce.entity;

import com.example.ecomerce.enums.RoomCategoryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "room_category")
public class RoomCategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    @Column(nullable = false, length = 2000)
    private String description;

    @NotNull(message = "Size is required")
    @Column(nullable = false)
    private Integer size;

    @NotBlank(message = "Bed Info is required")
    @Column(nullable = false, length = 100)
    private String bedInfo;

    @NotBlank(message = "Capacity is required")
    @Column(nullable = false, length = 100)
    private String capacity;

    @NotNull(message = "Price is required")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "Status is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomCategoryStatus status;

    @Column
    @CreatedDate
    private LocalDate createDate;

    @OneToMany(mappedBy = "roomCategory", cascade = CascadeType.ALL)
    private List<RoomEntity> room;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "roomcategory_promotion_relationship", joinColumns = @JoinColumn(name = "roomcategory_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "promotion_id", referencedColumnName = "id"))
    private Set<PromotionEntity> promotion;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "roomcategory_convenient_relationship", joinColumns = @JoinColumn(name = "roomcategory_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "convenient_id", referencedColumnName = "id"))
    private Set<ConvenientEntity> convenient;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roomCategory", cascade = CascadeType.ALL)
    private List<ImageEntity> imageEntities;

    @Transient
    private MultipartFile[] images;

    public RoomCategoryEntity() {
        // TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public RoomCategoryStatus getStatus() {
        return status;
    }

    public void setStatus(RoomCategoryStatus status) {
        this.status = status;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<RoomEntity> getRoom() {
        return room;
    }

    public void setRoom(List<RoomEntity> room) {
        this.room = room;
    }

    public Set<ConvenientEntity> getConvenient() {
        return convenient;
    }

    public void setConvenient(Set<ConvenientEntity> convenient) {
        this.convenient = convenient;
    }

    public Set<PromotionEntity> getPromotion() {
        return promotion;
    }

    public void setPromotion(Set<PromotionEntity> promotion) {
        this.promotion = promotion;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public MultipartFile[] getImages() {
        return images;
    }

    public void setImages(MultipartFile[] images) {
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
