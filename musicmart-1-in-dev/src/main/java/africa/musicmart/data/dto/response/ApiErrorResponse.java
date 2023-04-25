package africa.musicmart.data.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ApiErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private ZonedDateTime timeStamp;
    private Integer statusCode;
    private String path;
    private Object data;
    private Boolean isSuccessful;
}
