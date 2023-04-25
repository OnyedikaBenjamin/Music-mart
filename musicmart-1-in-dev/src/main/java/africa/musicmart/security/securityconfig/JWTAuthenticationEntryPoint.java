package africa.musicmart.security.securityconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> data = new HashMap<>();
        data.put("successful", false);
        data.put("localDateTime", dateFormat.format(Calendar.getInstance().getTime().getTime()));
        data.put("message", exception.getMessage());
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }
}
