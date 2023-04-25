package africa.musicmart.services;

import africa.musicmart.data.model.ForgotPassword;
import africa.musicmart.data.repositories.ForgotPasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ForgotPasswordService{
    @Autowired
    private ForgotPasswordRepository forgotPasswordRepository;

    public void saveForgotPasswordToken(ForgotPassword forgotPassword){
        forgotPasswordRepository.save(forgotPassword);
    }

    public Optional<ForgotPassword> getForgotPasswordToken(String token){
        return forgotPasswordRepository.findByToken(token);
    }

    public void deleteExpiredToken(){
        forgotPasswordRepository.deleteConfirmationTokensByExpiredAtBefore(LocalDateTime.now());
    }

    public void setConfirmedAt(String token){
        forgotPasswordRepository.setConfirmedAt(LocalDateTime.now(), token);
    }
}
