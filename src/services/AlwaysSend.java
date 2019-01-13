package services;

import data.DigitalSignature;
import data.MailAddress;
import exceptions.NoMailException;


public class AlwaysSend implements MailerService {
    private boolean enter=false;
    @Override
    public void send(MailAddress address, DigitalSignature signature) throws NoMailException{
        if(address.getMail().equals("invalidMail")){
            throw new NoMailException("Introduce valid mail please.");
        }else{
            enter=true;
        }
    }


}