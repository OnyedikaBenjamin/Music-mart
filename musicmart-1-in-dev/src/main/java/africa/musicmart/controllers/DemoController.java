package africa.musicmart.controllers;


import africa.musicmart.data.dto.request.PlaylistRequest;
import africa.musicmart.data.dto.response.ApiResponse;
import africa.musicmart.services.PlaylistService;
import africa.musicmart.utils.SpotifyClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import africa.musicmart.data.dto.request.ConfirmTokenRequest;
import africa.musicmart.data.dto.request.ForgotPasswordRequest;
import africa.musicmart.data.dto.request.LoginRequest;
import africa.musicmart.data.dto.request.RegistrationRequest;

import africa.musicmart.services.UserService;

import jakarta.validation.Valid;
;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {


    @Autowired
    private SpotifyClient spotifyClient;
    @Autowired
    private PlaylistService playlistService;

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid RegistrationRequest registrationRequest,
                                        HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(userService.signup(registrationRequest))
                .timestamp(ZonedDateTime.now())
                .path(request.getRequestURI())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


//    @GetMapping("/get-token")
//    public ResponseEntity<ApiResponse> getToken(HttpServletRequest request){
//        ApiResponse apiResponse=ApiResponse.builder()
//                .status(HttpStatus.OK.value())
//                .data(spotifyClient.getAccessToken())
//    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest,
                                    HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(userService.login(loginRequest))
                .timestamp(ZonedDateTime.now())
                .path(request.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/create-playlist")
    public ResponseEntity<ApiResponse> createPlaylist(@RequestBody  PlaylistRequest playlistRequest, HttpServletRequest httpServletRequest) throws IOException {
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(playlistService.createPlaylist(playlistRequest))
                .timestamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody @Valid ForgotPasswordRequest forgotPasswordRequest,
                                            HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(userService.forgotPassword(forgotPasswordRequest))
                .timestamp(ZonedDateTime.now())
                .path(request.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("/confirmToken")
    public ResponseEntity<?> confirmToken(@RequestBody @Valid ConfirmTokenRequest confirmTokenRequest,
                                          HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .data(userService.confirmToken(confirmTokenRequest))
                .timestamp(ZonedDateTime.now())
                .path(request.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}