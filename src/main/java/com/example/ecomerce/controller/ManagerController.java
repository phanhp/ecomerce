package com.example.ecomerce.controller;

import com.example.ecomerce.entity.*;
import com.example.ecomerce.enums.RoomStatus;
import com.example.ecomerce.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    RoomCategoryService roomCategoryService;

    @Autowired
    RoomService roomService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    PromotionService promotionService;

    @Autowired
    ImageService imageService;

    @Autowired
    UserDetailsServiceImpl userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingDetailsService bookingDetailsService;

    @Autowired
    ServiceBookingService serviceBookingService;

    @Autowired
    GuestService guestService;


    @RequestMapping("/home")
    public String viewHome(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        model.addAttribute("message", username);

        return "home-management";
    }

    // Room Category
    @GetMapping("/viewCategory")
    public String viewCategory(Model model) {

        model.addAttribute("roomCategoryList", roomCategoryService.findAll());

        return "manager/viewCategory";
    }

    @GetMapping("/searchCategory")
    public String searchCategory(Model model, @RequestParam(value = "search") String search) {

        model.addAttribute("roomCategoryList", roomCategoryService.searchByName(search));

        return "manager/viewCategory";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model) {

        RoomCategoryEntity roomCategory = new RoomCategoryEntity();
        model.addAttribute("roomCategory", roomCategory);

        return "manager/addCategory";
    }

    @PostMapping("/doAddCategory")
    public String doAddCategory(@Valid @ModelAttribute(name = "roomCategory") RoomCategoryEntity roomCategory,
                                BindingResult rs, Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {

            model.addAttribute("roomCategoryList", roomCategoryService.findAll());

            return "manager/addCategory";
        } else {

            if (roomCategory.getImages() != null && roomCategory.getImages().length > 0) {
                roomCategory.setImageEntities(
                        imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
            }
            roomCategory.setCreateDate(LocalDate.now());
            roomCategoryService.save(roomCategory);

            List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
            model.addAttribute("roomCategoryList", roomCategoryList);

            return "manager/viewCategory";
        }
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(Model model, @RequestParam(name = "id") int id) {

        roomCategoryService.deleteById(id);

        List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
        model.addAttribute("roomCategoryList", roomCategoryList);

        return "manager/viewCategory";

    }

    @GetMapping("/updateCategory")
    public String updateCategory(Model model, @RequestParam(name = "id") int id) throws Exception {

        RoomCategoryEntity opt_Category = roomCategoryService.findById(id);
        if (opt_Category != null) {
            model.addAttribute("roomCategory", opt_Category);

            return "manager/updateCategory";
        } else {
            return "error";
        }

    }

    @PostMapping("/doUpdateCategory")
    public String doUpdateCategory(@Valid @ModelAttribute(name = "roomCategory") RoomCategoryEntity roomCategory,
                                   BindingResult rs, Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {
            List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
            model.addAttribute("roomCategoryList", roomCategoryList);
            return "manager/updateCategory";

        } else {
            roomCategory.setImageEntities(
                    imageService.uploadImageCategory(roomCategory.getImages(), servletRequest, roomCategory));
        }

        roomCategoryService.save(roomCategory);

        List<RoomCategoryEntity> roomCategoryList = roomCategoryService.findAll();
        model.addAttribute("roomCategoryList", roomCategoryList);

        return "manager/viewCategory";
    }

    @GetMapping("/deleteImageCategory/{id}/{categoryId}")
    public String deleteImageCategory(Model model, @PathVariable(name = "id") int id,
                                      @PathVariable(name = "categoryId") int categoryId) {

        imageService.deleteImgCategory(categoryId, id);

        return "redirect:/manager/updateCategory?id=" + categoryId;
    }

    // Room
    @GetMapping("/viewRoom")
    public String viewRoom(Model model) {

        List<RoomEntity> roomList = roomService.findAll();
        model.addAttribute("roomList", roomList);

        return "manager/viewRoom";
    }

    @GetMapping("/addRoom")
    public String addRoom(Model model) {

        model.addAttribute("room", new RoomEntity());
        model.addAttribute("categoryList", roomCategoryService.findAll());
        model.addAttribute("status", RoomStatus.values());
        return "manager/addRoom";
    }

    @PostMapping("/doAddRoom")
    public String doAddRoom(@ModelAttribute(name = "room") RoomEntity room, Model model) {


        roomService.save(room);

        List<RoomEntity> roomList = roomService.findAll();
        model.addAttribute("roomList", roomList);

        return "manager/viewRoom";
    }

    // Service
    @GetMapping("/viewService")
    public String viewService(Model model) {

        List<ServiceEntity> serviceList = serviceService.findAll();
        model.addAttribute("serviceList", serviceList);

        return "manager/viewService";
    }

    @GetMapping("/searchService")
    public String searchService(Model model, @RequestParam(value = "search") String search) {

        model.addAttribute("serviceList", serviceService.searchByName(search));

        return "manager/viewService";
    }

    @GetMapping("/addService")
    public String addService(Model model) {

        model.addAttribute("service", new ServiceEntity());

        return "manager/addService";
    }

    @PostMapping("/doAddService")
    public String doAddService(@Valid @ModelAttribute(name = "service") ServiceEntity service, BindingResult rs,
                               Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {
            List<ServiceEntity> serviceList = serviceService.findAll();
            model.addAttribute("serviceList", serviceList);
            return "manager/addService";
        } else {

            if (service.getImages() != null && service.getImages().length > 0) {
                service.setImageEntities(imageService.uploadImageService(service.getImages(), servletRequest, service));
            }
            service.setCreateDate(LocalDate.now());
            serviceService.save(service);

            List<ServiceEntity> serviceList = serviceService.findAll();
            model.addAttribute("serviceList", serviceList);

            return "manager/viewService";
        }

    }


    @GetMapping("/updateService")
    public String updateService(Model model, @RequestParam(name = "id") int id) throws Exception {

        ServiceEntity opt_Service = serviceService.findById(id);
        if (opt_Service != null) {
            model.addAttribute("service", opt_Service);

            return "manager/updateService";
        } else {
            return "error";
        }

    }

    @PostMapping("/doUpdateService")
    public String doUpdateService(@Valid @ModelAttribute(name = "service") ServiceEntity service, BindingResult rs,
                                  Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {
            List<ServiceEntity> serviceList = serviceService.findAll();
            model.addAttribute("serviceList", serviceList);
            return "manager/updateCategory";

        } else {
            service.setImageEntities(imageService.uploadImageService(service.getImages(), servletRequest, service));
        }

        serviceService.save(service);

        List<ServiceEntity> serviceList = serviceService.findAll();
        model.addAttribute("serviceList", serviceList);

        return "manager/viewService";
    }

    @GetMapping("/deleteImageService/{id}/{serviceId}")
    public String deleteImageService(Model model, @PathVariable(name = "id") int id,
                                     @PathVariable(name = "serviceId") int serviceId) {

        imageService.deleteImgService(serviceId, id);

        return "redirect:/manager/updateService?id=" + serviceId;
    }

    // Promotion
    @GetMapping("/viewPromotion")
    public String viewPromotion(Model model) {

        List<PromotionEntity> promotionList = promotionService.findAll();
        model.addAttribute("promotionList", promotionList);

        return "manager/viewPromotion";
    }

    @GetMapping("/searchPromotion")
    public String searchPromotion(Model model, @RequestParam(value = "search") String search) {

        model.addAttribute("promotionList", promotionService.searchByName(search));

        return "manager/viewPromotion";
    }

    @GetMapping("/addPromotion")
    public String addPromotion(Model model) {

        model.addAttribute("promotion", new PromotionEntity());

        return "manager/addPromotion";
    }

    @PostMapping("/doAddPromotion")
    public String doAddPromotion(@Valid @ModelAttribute(name = "promotion") PromotionEntity promotion, BindingResult rs,
                                 Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {
            List<PromotionEntity> promotionList = promotionService.findAll();
            model.addAttribute("promotionList", promotionList);
            return "manager/addPromotion";
        } else {

            if (promotion.getImages() != null && promotion.getImages().length > 0) {
                promotion.setImageEntities(
                        imageService.uploadImagePromotion(promotion.getImages(), servletRequest, promotion));
            }
            promotion.setCreateDate(LocalDate.now());
            promotionService.save(promotion);

            List<PromotionEntity> promotionList = promotionService.findAll();
            model.addAttribute("promotionList", promotionList);

            return "manager/viewPromotion";
        }
    }

    @GetMapping("/updatePromotion")
    public String updatePromotion(Model model, @RequestParam(name = "id") int id) throws Exception {

        PromotionEntity opt_Promotion = promotionService.findById(id);
        if (opt_Promotion != null) {
            model.addAttribute("promotion", opt_Promotion);

            return "manager/updatePromotion";
        } else {
            return "error";
        }

    }

    @PostMapping("/doUpdatePromotion")
    public String doUpdatePromotion(@Valid @ModelAttribute(name = "promotion") PromotionEntity promotion,
                                    BindingResult rs, Model model, HttpServletRequest servletRequest) {

        if (rs.hasErrors()) {
            List<PromotionEntity> promotionList = promotionService.findAll();
            model.addAttribute("promotionList", promotionList);
            return "manager/updatePromotion";

        } else {
            promotion.setImageEntities(
                    imageService.uploadImagePromotion(promotion.getImages(), servletRequest, promotion));
        }

        promotionService.save(promotion);

        List<PromotionEntity> promotionList = promotionService.findAll();
        model.addAttribute("promotionList", promotionList);

        return "manager/viewPromotion";
    }

    @GetMapping("/deleteImagePromotion/{id}/{promotionId}")
    public String deleteImagePromotion(Model model, @PathVariable(name = "id") int id,
                                       @PathVariable(name = "promotionId") int promotionId) {

        imageService.deleteImgPromotion(promotionId, id);

        return "redirect:/manager/updatePromotion?id=" + promotionId;
    }

    @GetMapping("/deletePromotion")
    public String deletePromotion(Model model, @RequestParam(name = "id") int id) {

        promotionService.deleteById(id);

        List<PromotionEntity> promotionList = promotionService.findAll();
        model.addAttribute("promotionList", promotionList);

        return "manager/viewPromotion";

    }

    // Booking
    @GetMapping("/viewBooking")
    public String viewBooking(Model model) {

        List<BookingEntity> bookingList = bookingService.findAll();
        model.addAttribute("bookingList", bookingList);

        return "manager/viewBooking";
    }

    @GetMapping("/searchBooking")
    public String searchBooking(Model model, @RequestParam(value = "search") String search) {

        model.addAttribute("bookingList", bookingService.searchByName(search));

        return "manager/viewBooking";
    }

    @GetMapping("/bookingDetail")
    public String bookingDetail(Model model, @RequestParam(name = "id") int id) throws Exception {

        BookingEntity booking = bookingService.findById(id);

        List<BookingDetailEntity> bookingDetailList = bookingDetailsService.findByBookingId(id);

        if (booking != null) {

            model.addAttribute("bookingDetailList", bookingDetailList);
            model.addAttribute("booking", booking);

            return "manager/bookingDetail";
        } else {
            return "error";
        }

    }

    @PostMapping("/saveBookingDetail")
    public String saveBookingDetail(@Valid @ModelAttribute(name = "booking") BookingEntity booking, BindingResult rs,
                                    Model model) {

        if (rs.hasErrors()) {
            List<PromotionEntity> promotionList = promotionService.findAll();
            model.addAttribute("promotionList", promotionList);
            return "manager/updatePromotion";

        }

        bookingService.save(booking);

        List<BookingEntity> bookingList = bookingService.findAll();
        model.addAttribute("bookingList", bookingList);

        return "manager/viewBooking";
    }

    @GetMapping("/addServiceBooking")
    public String addServiceBooking(Model model, @RequestParam(name = "id") int id) throws Exception {

        BookingDetailEntity bookingDetail = bookingDetailsService.findbyId(id);

        List<ServiceBookingEntity> serviceBookingList = serviceBookingService.findByBookingDetailId(id);
        if (bookingDetail != null) {
            model.addAttribute("serviceBookingList", serviceBookingList);
            model.addAttribute("bookingDetail", bookingDetail);
            model.addAttribute("serviceBooking", new ServiceBookingEntity());
            model.addAttribute("serviceList", serviceService.findAll());
            return "manager/addServiceBooking";
        } else {
            return "error";
        }

    }

    @PostMapping("/doAddServiceBooking")
    public String doAddServiceBooking(Model model,
                                      @ModelAttribute(name = "serviceBooking") ServiceBookingEntity serviceBooking,
                                      @RequestParam(name = "bookingDetailId") int bookingDetailId) {
        if (serviceBooking != null && serviceBooking.getService() != null
                && serviceBooking.getService().getId() != null) {
            ServiceBookingEntity sb = null;
            Optional<ServiceBookingEntity> sbOpt = serviceBookingService.findByBookingDetailAndService(bookingDetailId,
                    serviceBooking.getService().getId());
            if (sbOpt.isPresent()) {
                sb = sbOpt.get();
                sb.setQuantity(serviceBooking.getQuantity());
                sb.setPrice((int) (serviceBooking.getQuantity() * sb.getService().getPrice()));
            } else {
                ServiceEntity service = serviceService.findById(serviceBooking.getService().getId());
                if (service != null) {
                    sb = new ServiceBookingEntity();
                    sb.setQuantity(serviceBooking.getQuantity());
                    sb.setPrice((int) (serviceBooking.getQuantity() * service.getPrice()));
                    sb.setServiceBookingDate(LocalDate.now());
                    sb.setService(service);
                    sb.setBookingDetail(bookingDetailsService.findbyId(bookingDetailId));
                }
            }
            serviceBookingService.save(sb);
        }
        return "redirect:/manager/addServiceBooking?id=" + bookingDetailId;
    }

    @GetMapping("/deleteServiceInServiceBooking")
    public String deleteServiceInServiceBooking(Model model, @RequestParam(name = "id") int id,
                                                @RequestParam(name = "bookingDetailId") int bookingDetailId) {

        bookingDetailsService.deleteServiceBooking(id, bookingDetailId);

        return "redirect:/manager/addServiceBooking?id=" + bookingDetailId;

    }

    @GetMapping("/addGuest")
    public String addGuest(Model model, @RequestParam(name = "id") int id) throws Exception {

        BookingDetailEntity bookingDetail = bookingDetailsService.findbyId(id);

        List<GuestEntity> guestList = guestService.findByBookingDetailId(id);
        if (bookingDetail != null) {
            model.addAttribute("guestList", guestList);
            model.addAttribute("bookingDetail", bookingDetail);
            model.addAttribute("guest", new GuestEntity());

            return "manager/addGuest";
        } else {
            return "error";
        }

    }

    @PostMapping("/doAddGuest")
    public String doAddGuest(Model model, @ModelAttribute(name = "serviceBooking") GuestEntity guest,
                             @RequestParam(name = "bookingDetailId") int bookingDetailId) {

        guest.setBookingDetail(bookingDetailsService.findbyId(bookingDetailId));
        guestService.save(guest);

        return "redirect:/manager/addGuest?id=" + bookingDetailId;
    }

    @GetMapping("/deleteGuest")
    public String deleteGuest(Model model, @RequestParam(name = "id") int id,
                              @RequestParam(name = "bookingDetailId") int bookingDetailId) {

        bookingDetailsService.deleteGuest(id, bookingDetailId);

        return "redirect:/manager/addGuest?id=" + bookingDetailId;

    }

    @GetMapping("/updateGuest")
    public String updateGuest(Model model, @RequestParam(name = "id") int id,
                              @RequestParam(name = "bookingDetailId") int bookingDetailId) throws Exception {

        BookingDetailEntity bookingDetail = bookingDetailsService.findbyId(bookingDetailId);

        List<GuestEntity> guestList = guestService.findByBookingDetailId(bookingDetailId);
        if (bookingDetail != null) {

            Optional<GuestEntity> guest = guestService.findById(id);

            model.addAttribute("guestList", guestList);
            model.addAttribute("bookingDetail", bookingDetail);
            model.addAttribute("guest", guest);

            return "manager/addGuest";
        } else {
            return "error";
        }

    }

    @PostMapping("/doUpdateGuest")
    public String doUpdateGuest(Model model, @ModelAttribute(name = "serviceBooking") GuestEntity guest,
                                @RequestParam(name = "bookingDetailId") int bookingDetailId) {

        guest.setBookingDetail(bookingDetailsService.findbyId(bookingDetailId));
        guestService.save(guest);

        return "redirect:/manager/addGuest?id=" + bookingDetailId;
    }

}
