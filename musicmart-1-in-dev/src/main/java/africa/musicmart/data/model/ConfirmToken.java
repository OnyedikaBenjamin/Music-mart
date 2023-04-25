package africa.musicmart.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class ConfirmToken{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( nullable = false)
    private String id;
    private  String token;
    private LocalDateTime createAt;
    private  LocalDateTime expiredAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    private AppUser appUser;
    public ConfirmToken(String token,
                        LocalDateTime createAt,
                        LocalDateTime expiredAt,
                        AppUser appUser){
        this.token=token;
        this.createAt=createAt;
        this.expiredAt=expiredAt;
        this.appUser=appUser;
    }
}
