package com.psdev.bookmyshowskelton.dto;

import com.psdev.bookmyshowskelton.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private int amount;
    private ResponseStatus responseStatus;
}
