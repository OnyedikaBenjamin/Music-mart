package africa.musicmart.data.repositories;

import africa.musicmart.data.model.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{
    Optional<AppUser> findByEmailIgnoreCase(String email);

    Optional<AppUser> findByUsername(String username);
}
