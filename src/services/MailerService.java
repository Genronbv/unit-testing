package services;

import data.DigitalSignature;
import data.MailAddress;
import exceptions.NoMailException;


/**
 * External service for sending mails
 */
public interface MailerService {
    void send(MailAddress address, DigitalSignature signature) throws NoMailException;

}
