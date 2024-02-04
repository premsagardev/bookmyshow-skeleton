package com.psdev.bookmyshowskelton.repositories;

import com.psdev.bookmyshowskelton.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}
