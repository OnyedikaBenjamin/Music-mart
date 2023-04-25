package africa.musicmart.data.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiResponse {
    @JsonFormat(pattern = "yyyy-MM-dd || HH:mm:ss")
    private ZonedDateTime timestamp;
    private Integer status;
    private Object data;
    private String path;
    private boolean isSuccessful;
}
