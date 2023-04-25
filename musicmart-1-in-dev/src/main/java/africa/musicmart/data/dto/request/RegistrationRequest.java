package africa.musicmart.data.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class RegistrationRequest {
    @NotBlank
    private String username;
    @NotBlank
    @Email(message="Please input a valid email")
    private String email;
    @Pattern(regexp="^([a-zA-Z\\d@*#$&!]{5,15})$")
    @NotBlank
    private String password;
}
