package com.psdev.bookmyshowskelton.controllers;

import com.psdev.bookmyshowskelton.dto.SignUpRequestDto;
import com.psdev.bookmyshowskelton.dto.SignUpResponseDto;
import com.psdev.bookmyshowskelton.models.ResponseStatus;
import com.psdev.bookmyshowskelton.models.User;
import com.psdev.bookmyshowskelton.repositories.UserRepository;
import com.psdev.bookmyshowskelton.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Getter
@Setter
@Controller
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        Optional<User> optionalUser = userRepository.findByEmail(signUpRequestDto.getEmail());
        SignUpResponseDto responseDto = new SignUpResponseDto();
        if (optionalUser.isEmpty()) {
            // signup
            try {
                User user = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
                responseDto.setResponseStatus(ResponseStatus.SUCCESS);
                responseDto.setUserId(user.getId());
            } catch (Exception exception) {
                responseDto.setResponseStatus(ResponseStatus.FAILURE);
            }
        } else {
            // login
            try {
                User user = userService.login(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
                responseDto.setUserId(user.getId());
                responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            } catch (Exception exception) {
                responseDto.setResponseStatus(ResponseStatus.FAILURE);
            }
        }
        return responseDto;
    }
}
