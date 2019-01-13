package kiosk;

import data.DigitalSignature;
import data.MailAddress;
import data.Party;
import exceptions.*;
import services.*;

import java.util.*;


/**
 * Implements a simplification of Use Case: Emit
 e
 Vote
 */

public class VotingKiosk{

    private ElectoralOrganism eO;
    private MailerService mService;
    private Party party;
    private VoteCounter vc; //= new VoteCounter(new HashSet<>(Arrays.asList(new Party("pp"),new Party("psoe"),new Party("ERC"))));


    public VotingKiosk(){

    }

    public VotingKiosk(VoteCounter vc) {
        this.vc=vc;
    }


    public void setElectoralOrganism(ElectoralOrganism eO) { this.eO=eO; }
    public void setMailerService(MailerService mService){
        this.mService=mService;
    }


    public void vote(Party party) throws NoPartyException {
        vc.scrutinize(party);
        this.party=party;
    }

    public void sendeReceipt(MailAddress address) throws NoSignatureException, NoMailException {
        DigitalSignature ds = eO.askForDigitalSignature(party);
        mService.send(address, ds);

    }

}