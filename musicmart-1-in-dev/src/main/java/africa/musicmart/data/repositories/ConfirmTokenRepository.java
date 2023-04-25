package africa.musicmart.data.repositories;

import africa.musicmart.data.model.ConfirmToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmTokenRepository extends JpaRepository<ConfirmToken, String>{
    Optional<ConfirmToken> findByToken(String token);

    @Transactional
    void deleteConfirmTokensByExpiredAtBefore(LocalDateTime currentTime);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmToken confirmToken " +
            "SET confirmToken.confirmedAt = ?1 " +
            "WHERE confirmToken.confirmedAt = ?2 "
    )
    void setConfirmedAt(LocalDateTime currentTime, String Token);

}
