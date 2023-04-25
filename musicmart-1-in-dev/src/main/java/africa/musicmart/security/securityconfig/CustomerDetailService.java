package africa.musicmart.security.securityconfig;

import africa.musicmart.data.model.AppUser;
import africa.musicmart.data.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class CustomerDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException(format("AppUser not found with email %s", email)));
        return UserPrincipal.create(appUser);
    }
}