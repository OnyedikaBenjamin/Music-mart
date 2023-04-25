package africa.musicmart.data.dto.response;

import lombok.Data;

@Data
public class TokenResponse {
    private String access_token;
    private String token_type;
    private int expires_in;
}
