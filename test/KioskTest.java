import data.*;
import exceptions.*;
import kiosk.*;
import services.*;

import java.util.*;
import org.junit.jupiter.api.*;
import services.MailerService;

import static org.junit.jupiter.api.Assertions.*;

public class KioskTest {

    @Test
    public void newVoteTest() throws NoNameException, NoPartyException, NoMailException, NoSignatureException {
        ElectoralOrganism eo = new AlwaysValid();
        MailerService as = new AlwaysSend();
        Set<Party> set = new HashSet<>(Arrays.asList(new Party("pp"), new Party("psoe"), new Party("ERC")));
        VoteCounter vc = new VoteCounter(set);
        VotingKiosk vk = new VotingKiosk(vc);
        vk.setMailerService(as);
        vk.setElectoralOrganism(eo);
        vk.vote(new Party("psoe"));
        MailAddress ma = new MailAddress("gbv4@alumnes.udl.cat");
        vk.sendeReceipt(ma);
    }

    @Test
    public void invalidMailTest() throws NoNameException, NoMailException, NoPartyException {
        ElectoralOrganism eo = new AlwaysValid();
        MailerService as = new AlwaysSend();
        Set<Party> set = new HashSet<>(Arrays.asList(new Party("pp"), new Party("psoe"), new Party("ERC")));
        VoteCounter vc = new VoteCounter(set);
        VotingKiosk vk = new VotingKiosk(vc);
        vk.setMailerService(as);
        vk.setElectoralOrganism(eo);
        vk.vote(new Party("psoe"));
        MailAddress ma = new MailAddress("invalidMail");
        Throwable validmail = assertThrows(NoMailException.class,
                ()->{vk.sendeReceipt(ma);});



    }


}