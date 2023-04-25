package africa.musicmart.data.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ForgotPasswordRequest{
    @NotBlank(message="Field cannot be empty")
    @Email(message="Input a valid email ")
    private String email;
}
