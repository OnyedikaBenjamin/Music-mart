package africa.musicmart.services;

import africa.musicmart.data.model.ConfirmToken;
import africa.musicmart.data.repositories.ConfirmTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmTokenService{
    @Autowired
    ConfirmTokenRepository confirmTokenRepository;

    public void saveConfirmToken(ConfirmToken confirmationToken){
        confirmTokenRepository.save(confirmationToken);
    }

    public Optional<ConfirmToken> getConfirmToken(String token){
        return confirmTokenRepository.findByToken(token);
    }

    public void deleteExpiredToken(){
        confirmTokenRepository.deleteConfirmTokensByExpiredAtBefore(LocalDateTime.now());
    }

    public void setConfirmedAt(String token){
        confirmTokenRepository.setConfirmedAt(LocalDateTime.now(), token);
    }

}
