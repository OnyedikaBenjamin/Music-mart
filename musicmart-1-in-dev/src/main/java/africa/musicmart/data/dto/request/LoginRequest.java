package africa.musicmart.data.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginRequest{
    @NotBlank
    private String username;
    @NotBlank
    @Pattern(regexp="^([a-zA-Z\\d@*#$&!]{5,15})$")
    private String  password;
}
