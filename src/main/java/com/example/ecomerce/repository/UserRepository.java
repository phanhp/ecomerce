package com.example.ecomerce.repository;

import com.example.ecomerce.entity.UserEntity;
import com.example.ecomerce.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmailLikeAndStatusLike(String email,
                                            UserStatus status);

    @Query("select u from UserEntity u where u.fullName like %:keyword% ")
    public List<UserEntity> searchByName(@Param("keyword") String keyword);
}
