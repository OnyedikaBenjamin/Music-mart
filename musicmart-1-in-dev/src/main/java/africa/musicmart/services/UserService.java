package africa.musicmart.services;

import africa.musicmart.data.dto.request.ConfirmTokenRequest;
import africa.musicmart.data.dto.request.ForgotPasswordRequest;
import africa.musicmart.data.dto.request.LoginRequest;
import africa.musicmart.data.dto.request.RegistrationRequest;
import africa.musicmart.data.dto.response.ApiData;


public interface UserService {
    ApiData signup(RegistrationRequest registrationRequest);
    String login (LoginRequest loginRequest);
    String forgotPassword(ForgotPasswordRequest forgotPasswordRequest);
    String confirmToken(ConfirmTokenRequest confirmTokenRequest);
   // void enableUser(String email);

}
