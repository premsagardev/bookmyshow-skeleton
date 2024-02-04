package com.psdev.bookmyshowskelton.dto;

import com.psdev.bookmyshowskelton.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
