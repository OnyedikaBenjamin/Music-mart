package africa.musicmart.data.model;

import africa.musicmart.services.ConfirmTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class DeleteExpiredToken{
    @Autowired
   ConfirmTokenService confirmTokenService;

    @Scheduled(cron="0 0 0 * * *")
    public void deleteExpiredToken(){
        confirmTokenService.deleteExpiredToken();
    }


}
