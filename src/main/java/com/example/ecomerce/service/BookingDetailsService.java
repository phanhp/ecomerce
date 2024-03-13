package com.example.ecomerce.service;

import com.example.ecomerce.entity.BookingDetailEntity;
import com.example.ecomerce.entity.GuestEntity;
import com.example.ecomerce.entity.ServiceBookingEntity;
import com.example.ecomerce.repository.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingDetailsService {

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

    @Autowired
    ServiceBookingService serviceBookingService;

    @Autowired
    GuestService guestService;


    public void save(BookingDetailEntity bookingDetails) {
        bookingDetailsRepository.save(bookingDetails);
    }

    public List<BookingDetailEntity> findAll() {
        return (List<BookingDetailEntity>) bookingDetailsRepository.findAll();
    }

    public List<BookingDetailEntity> findByBookingId(int id) {
        return bookingDetailsRepository.findByBookingId(id);
    }

    public BookingDetailEntity findbyId(int id) {
        return bookingDetailsRepository.findById(id).orElse(null);
    }

    public void deleteServiceBooking(int serviceBookingid, int bookingDetailId) {

        Optional<ServiceBookingEntity> opt_serviceBooking = serviceBookingService.findById(serviceBookingid);

        if (opt_serviceBooking.isPresent()) {
            ServiceBookingEntity svBooking = opt_serviceBooking.get();
            svBooking.setBookingDetail(null);
            serviceBookingService.save(svBooking);
            serviceBookingService.deleteById(serviceBookingid);
        }

    }

    public void deleteGuest(int guestId, int bookingDetailId) {

        Optional<GuestEntity> opt_guest = guestService.findById(guestId);

        if (opt_guest.isPresent()) {
            GuestEntity guest = opt_guest.get();
            guest.setBookingDetail(null);
            guestService.save(guest);
            guestService.deleteById(guestId);
        }

    }

}
