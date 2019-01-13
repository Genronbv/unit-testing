import data.*;
import exceptions.*;
import kiosk.*;
import services.*;

import java.util.*;
import org.junit.jupiter.api.*;
import services.MailerService;

import static org.junit.jupiter.api.Assertions.*;

public class KioskTest {
    public ElectoralOrganism eo;
    public MailerService as;
    public VoteCounter vc;
    public VotingKiosk vk;

    @BeforeEach
    void initAll() throws NoNameException {
        eo = new AlwaysValid();
        as = new AlwaysSend();
        Set<Party> set = new HashSet<>(Arrays.asList(new Party("pp"), new Party("psoe"), new Party("ERC")));
        vc = new VoteCounter(set);
        vk = new VotingKiosk(vc);
    }

    @Test
    public void newVoteTest() throws NoNameException, NoPartyException{
        vk.setMailerService(as);
        vk.setElectoralOrganism(eo);
        vk.vote(new Party("psoe"));
    }


    @Test
    public void newMailTest() throws NoMailException, NoSignatureException {
        vk.setMailerService(as);
        vk.setElectoralOrganism(eo);
        MailAddress ma = new MailAddress("gbv4@alumnes.udl.cat");
        vk.sendeReceipt(ma);
    }

    @Test
    public void invalidMailTest() throws NoNameException, NoMailException, NoPartyException {
        vk.setMailerService(as);
        vk.setElectoralOrganism(eo);
        vk.vote(new Party("psoe"));
        MailAddress ma = new MailAddress("invalidMail");
        Throwable validmail = assertThrows(NoMailException.class,
                ()->{vk.sendeReceipt(ma);});



    }

    @AfterEach
    public void teardown(){}


}