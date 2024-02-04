package com.psdev.bookmyshowskelton.controllers;

import com.psdev.bookmyshowskelton.dto.BookMovieRequestDto;
import com.psdev.bookmyshowskelton.dto.BookMovieResponseDto;
import com.psdev.bookmyshowskelton.models.Booking;
import com.psdev.bookmyshowskelton.models.ResponseStatus;
import com.psdev.bookmyshowskelton.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController { //Waiter.
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto) {
        BookMovieResponseDto response = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(),
                    bookMovieRequestDto.getShowSeatIds());

            response.setBookingId(booking.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setAmount(booking.getAmount());
        } catch (RuntimeException runtimeException) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }

    public Booking cancelMovie() {
        return null;
    }
}
