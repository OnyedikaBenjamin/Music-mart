package africa.musicmart.data.repositories;

import africa.musicmart.data.model.ForgotPassword;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, String>{
    Optional<ForgotPassword> findByToken(String token);

    void deleteConfirmationTokensByExpiredAtBefore(LocalDateTime currentTime);
    @Transactional
    @Modifying
    @Query("UPDATE ForgotPassword forgotPassword " +
            "SET forgotPassword.confirmedAt = ?1 " +
            "WHERE forgotPassword.confirmedAt  = ?2 "
    )
    void setConfirmedAt(LocalDateTime currentTime, String Token);
}
