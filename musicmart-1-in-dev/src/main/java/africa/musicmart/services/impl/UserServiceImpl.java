package africa.musicmart.services.impl;

import africa.musicmart.Email.EmailSender;
import africa.musicmart.data.dto.request.ConfirmTokenRequest;
import africa.musicmart.data.dto.request.ForgotPasswordRequest;
import africa.musicmart.data.dto.request.LoginRequest;
import africa.musicmart.data.dto.request.RegistrationRequest;
import africa.musicmart.data.dto.response.ApiData;
import africa.musicmart.data.model.AppUser;
import africa.musicmart.data.model.ConfirmToken;
import africa.musicmart.data.repositories.UserRepository;
import africa.musicmart.exception.GenericException;
import africa.musicmart.services.ConfirmTokenService;
import africa.musicmart.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    ConfirmTokenService confirmTokenService;

    EmailSender emailSender;

    @Override
    public ApiData signup(RegistrationRequest registrationRequest) {
        if(findByEmailIgnoreCase(registrationRequest.getEmail())
                .isPresent()) throw new GenericException(String.format(" %s already exist ", registrationRequest.getEmail()));
        if(findByUsername(registrationRequest.getUsername())
                .isPresent())  throw new GenericException(String.format("%s already taken", registrationRequest.getUsername()));

        var user = AppUser.builder()
                .username(registrationRequest.getUsername())
                .email(registrationRequest.getEmail().toLowerCase())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .build();
        userRepository.save(user);

        return ApiData.builder()
                .data("AppUser Registration successful")
                .build();
    }

    private Optional<AppUser> findByEmailIgnoreCase(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
    private Optional<AppUser>findByUsername(String username){
        return  userRepository.findByUsername(username);
    }

    @Override
    public String login(LoginRequest loginRequest){
        var findUser = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(()-> new GenericException(String.format("%s not found", loginRequest.getUsername())));
   if(!passwordEncoder.matches(loginRequest.getPassword(),findUser.getPassword())){
    throw new GenericException("Invalid login details");
     }
    return "Login successful";
    }

    @Override
    public String forgotPassword(ForgotPasswordRequest forgotPasswordRequest){
        var findUser = userRepository.findByEmailIgnoreCase(forgotPasswordRequest.getEmail())
                .orElseThrow(()-> new RuntimeException("User not found"));

        String token = generateToken(findUser);
        emailSender.send(findUser.getEmail(), forgotPasswordEmail(findUser.getUsername(), token));

        return token;

    }
    public String generateToken (AppUser appUser){

        SecureRandom secureRandom=new SecureRandom();
        String token=String.valueOf(1000 + secureRandom.nextInt(9999));
        ConfirmToken confirmationToken = new ConfirmToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                appUser);

        confirmTokenService.saveConfirmToken(confirmationToken);
        return token;
    }


    public String forgotPasswordEmail(String username,String token){
        return "Here's the link to reset your password"
                + "                                      "
                +"                                        "
                +"<p>Hello \"" + username + "\",</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + token + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
    }


    @Override
    public String confirmToken(ConfirmTokenRequest confirmTokenRequest){
        return null;
    }
}