package africa.musicmart.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class ForgotPassword{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    @NotNull
    private  String token;
    @NotNull
    private LocalDateTime createAt;
    @NotNull
    private  LocalDateTime expiredAt;

    private LocalDateTime confirmedAt;
    @ManyToOne
    private AppUser appUser;

    public ForgotPassword(String token,
                          LocalDateTime createAt,
                          LocalDateTime expiredAt,
                          AppUser appUser){
        this.token=token;
        this.createAt=createAt;
        this.expiredAt=expiredAt;
        this.appUser=appUser;
    }
}
