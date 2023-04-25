package africa.musicmart.exception;

import africa.musicmart.data.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleGenericException(GenericException genericException,
                                                    HttpServletRequest httpServletRequest){
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .isSuccessful(false)
                .data(genericException.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .path(httpServletRequest.getRequestURI())
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OAuth2AuthenticationProcessingException.class)
    public ResponseEntity<?> handleAuthenticationProcessingException(GenericException genericException,
                                                    HttpServletRequest httpServletRequest){
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .isSuccessful(false)
                .data(genericException.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .path(httpServletRequest.getRequestURI())
                .timeStamp(ZonedDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
