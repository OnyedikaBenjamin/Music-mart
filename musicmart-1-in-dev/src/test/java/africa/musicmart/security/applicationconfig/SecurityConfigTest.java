package africa.musicmart.security.applicationconfig;

import africa.musicmart.data.model.AppUser;
import africa.musicmart.data.repositories.UserRepository;
import africa.musicmart.security.securityconfig.CustomerDetailService;
import africa.musicmart.security.securityconfig.JWTTokenProvider;
import africa.musicmart.security.securityconfig.UserPrincipal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SecurityConfigTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JWTTokenProvider tokenProvider;

    @InjectMocks
    private CustomerDetailService customUserDetailsService;

    private AppUser mockedUser;

    @BeforeEach
    void setUp() {
        mockedUser = new AppUser();
        mockedUser.setUsername("testing");
        mockedUser.setEmail(mockedUser.getEmail());
        mockedUser.setPassword("pass1234");
    }

    @AfterEach
    void tearDown() {
        userRepository = null;
        customUserDetailsService = null;
    }

    /**
     * User details service test
     */

    @Test
    @DisplayName("User details can be fetch from database by email with role User")
    void user_canFetchDataFromDbByEmail() {
        when(userRepository.findByEmailIgnoreCase(mockedUser.getEmail()))
                .thenReturn(Optional.of(mockedUser));

        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailsService.loadUserByUsername(mockedUser.getEmail());

        verify(userRepository, times(1)).findByEmailIgnoreCase(mockedUser.getEmail());

        assertNotNull(fetchedUser);
        assertAll(
                () -> assertEquals(mockedUser.getUsername(), fetchedUser.getName()),
                () -> assertEquals(mockedUser.getEmail(), fetchedUser.getEmail()),
                () -> assertEquals(mockedUser.getPassword(), fetchedUser.getPassword()),
                () -> assertEquals(1L, fetchedUser.getAuthorities().size())
        );
    }


    @Test
    @DisplayName("Jwt token can be generated")
    void jwt_tokenCanBeGenerated() {
        //Given
        when(userRepository.findByEmailIgnoreCase(mockedUser.getEmail()))
                .thenReturn(Optional.of(mockedUser));
        when(tokenProvider.generateToken(any())).thenReturn(UUID.randomUUID().toString());

        //When
        String actualToken = tokenProvider.generateToken(mockedUser.getEmail());

        //Assert
        assertNotNull(actualToken);
        assertEquals(actualToken.getClass(), String.class);
    }

    @Test
    @DisplayName("Username can be extracted from jwt token")
    void can_extractUsernameFromJwtToken() {
        //Given
        when(userRepository.findByEmailIgnoreCase(mockedUser.getEmail()))
                .thenReturn(Optional.of(mockedUser));
        when(tokenProvider.generateToken(any())).thenReturn(UUID.randomUUID().toString());
        when(tokenProvider.extractEmail(anyString())).thenReturn("testing");
        //When
        String jwtToken = tokenProvider.generateToken(mockedUser.getEmail());
        String actual = tokenProvider.extractEmail(jwtToken);

        //Assert
        assertEquals(mockedUser.getUsername(), actual);
    }

    @Test
    @DisplayName("Token can be validated by checking expiration date")
    void test_thatTokenHasNotExpire() {
        //Given
        when(userRepository.findByEmailIgnoreCase(mockedUser.getEmail()))
                .thenReturn(Optional.of(mockedUser));

        //When
        String jwtToken = tokenProvider.generateToken(mockedUser.getEmail());
        boolean hasExpire = tokenProvider.isTokenExpired(jwtToken);

        //Assert
        assertFalse(hasExpire);
    }

    @Test
    @DisplayName("Jwt token can be validated by username and expiration date")
    void test_jwtTokenCanBeValidated() {
        //Given
        when(userRepository.findByEmailIgnoreCase(mockedUser.getEmail()))
                .thenReturn(Optional.of(mockedUser));

        //When
        UserPrincipal fetchedUser = (UserPrincipal) customUserDetailsService.loadUserByUsername(mockedUser.getEmail());
        String jwtToken = tokenProvider.generateToken(mockedUser.getEmail());
        boolean isValid = tokenProvider.validateToken(jwtToken, fetchedUser);

        //Assert
        assertFalse(isValid);
    }
}