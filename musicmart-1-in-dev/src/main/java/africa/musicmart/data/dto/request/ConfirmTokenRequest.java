package africa.musicmart.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ConfirmTokenRequest{
    @NotBlank
    private String token;
    @NotBlank
    private String email;
}
