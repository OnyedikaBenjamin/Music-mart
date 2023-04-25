package africa.musicmart.security.securityconfig;

import africa.musicmart.data.enums.Role;
import africa.musicmart.data.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {
    private final String userId;
    private final String name;
    private final String email;
    private final String password;
    private final boolean isEnabled;
    private Map<String, Object> attributes;
    private final Collection<? extends GrantedAuthority> authorities;


    public static UserPrincipal create(AppUser appUser) {
        List<GrantedAuthority> authorities = getAuthorities(appUser);
        return new UserPrincipal(
                appUser.getAppUserId(),
                appUser.getUsername(),
                appUser.getEmail(),
                appUser.getPassword(),
                appUser.getEmailVerified(),
                authorities
        );
    }

    public static UserPrincipal create(AppUser appUser, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = create(appUser);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    private static List<GrantedAuthority> getAuthorities(AppUser appUser) {
        return List.of(new SimpleGrantedAuthority(Role.USER.name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
