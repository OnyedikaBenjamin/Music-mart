package africa.musicmart.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( nullable = false)
    private String appUserId;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
    private Boolean emailVerified;
}