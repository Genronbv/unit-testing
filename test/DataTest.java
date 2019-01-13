import data.*;
import exceptions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class DataTest {

    @Test
    public void NoNameTest(){
        Throwable nullname = assertThrows(NoNameException.class,
                ()->{Party pp =new Party(null);});

    }

    @Test
    public void NoMailException(){
        Throwable nullmail = assertThrows(NoMailException.class,
                ()->{
                    MailAddress mail =new MailAddress(null);});

        Throwable nomail = assertThrows(NoMailException.class,
                ()->{
                    MailAddress mail =new MailAddress("");});
    }

    @Test
    public void NoSignatureException(){
        Throwable nullname = assertThrows(NoSignatureException.class,
                ()->{
                    DigitalSignature dignature =new DigitalSignature(null);});

    }

    @Test
    public void NoNifException(){
        Throwable nullnif = assertThrows(NoNifException.class,
                ()->{
                    Nif genis =new Nif(null);});

        Throwable nonif = assertThrows(NoNifException.class,
                ()->{
                    Nif genis =new Nif("");});
    }
}
