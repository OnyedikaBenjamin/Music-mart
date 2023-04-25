package africa.musicmart.data.dto.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private String message;
    private HttpStatus status;
}
