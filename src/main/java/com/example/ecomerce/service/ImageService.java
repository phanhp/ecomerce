package com.example.ecomerce.service;

import com.example.ecomerce.entity.ImageEntity;
import com.example.ecomerce.entity.PromotionEntity;
import com.example.ecomerce.entity.RoomCategoryEntity;
import com.example.ecomerce.entity.ServiceEntity;
import com.example.ecomerce.repository.ImageRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public void save(ImageEntity image) {
        imageRepository.save(image);
    }

    public Optional<ImageEntity> findById(int id) {
        return imageRepository.findById(id);
    }

    public void deleteImgCategory(int categoryId, int id) {

        imageRepository.deleteImgCategory(categoryId, id);
    }

    public void deleteImgService(int serviceId, int id) {

        imageRepository.deleteImgService(serviceId, id);
    }

    public void deleteImgPromotion(int promotionId, int id) {

        imageRepository.deleteImgPromotion(promotionId, id);
    }

    public List<ImageEntity> uploadImageService(MultipartFile[] files, HttpServletRequest servletRequest,
                                                ServiceEntity service) {

        List<ImageEntity> lstImages = new ArrayList<ImageEntity>();

        if (service.getId() == null) {

        } else {
            if (service.getImageEntities() != null) {
                lstImages = service.getImageEntities();
            }
        }
        for (MultipartFile multipartFile : files) {
            UUID uuid = UUID.randomUUID();
            if (multipartFile.getOriginalFilename().length() > 0) {

                String fileName = "-service-  " + uuid.toString() + multipartFile.getOriginalFilename();
                ImageEntity image = new ImageEntity();
                image.setName(fileName);
                image.setService(service);
                lstImages.add(image);

                File imageFile = new File(
                        servletRequest.getServletContext().getRealPath("/resources-management/assets/img"), fileName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lstImages;
    }

    public List<ImageEntity> uploadImageCategory(MultipartFile[] files, HttpServletRequest servletRequest,
                                                 RoomCategoryEntity roomCategory) {

        List<ImageEntity> lstImages = new ArrayList<ImageEntity>();

        if (roomCategory.getId() == null) {

        } else {
            if (roomCategory.getImageEntities() != null) {
                lstImages = roomCategory.getImageEntities();
            }
        }
        for (MultipartFile multipartFile : files) {
            UUID uuid = UUID.randomUUID();
            if (multipartFile.getOriginalFilename().length() > 0) {

                String fileName = "-category-  " + uuid.toString() + multipartFile.getOriginalFilename();
                ImageEntity image = new ImageEntity();
                image.setName(fileName);
                image.setRoomCategory(roomCategory);
                lstImages.add(image);

                File imageFile = new File(
                        servletRequest.getServletContext().getRealPath("/resources-management/assets/img"), fileName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return lstImages;
    }

    public List<ImageEntity> uploadImagePromotion(MultipartFile[] files, HttpServletRequest servletRequest,
                                                  PromotionEntity promotion) {

        List<ImageEntity> lstImages = new ArrayList<ImageEntity>();

        if (promotion.getId() == null) {

        } else {
            if (promotion.getImageEntities() != null) {
                lstImages = promotion.getImageEntities();
            }
        }
        for (MultipartFile multipartFile : files) {

            UUID uuid = UUID.randomUUID();
            String fileName = "-promotion-" + uuid.toString() + multipartFile.getOriginalFilename();
            ImageEntity image = new ImageEntity();
            image.setName(fileName);
            image.setPromotion(promotion);
            lstImages.add(image);

            File imageFile = new File(
                    servletRequest.getServletContext().getRealPath("/resources-management/assets/img"), fileName);
            try {
                multipartFile.transferTo(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lstImages;
    }

}
