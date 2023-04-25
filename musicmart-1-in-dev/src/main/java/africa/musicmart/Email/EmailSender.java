package africa.musicmart.Email;

import africa.musicmart.exception.GenericException;

public interface EmailSender{
    void send(String to, String email) throws GenericException;
}
