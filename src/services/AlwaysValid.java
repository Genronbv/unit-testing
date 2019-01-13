package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import exceptions.NoSignatureException;

public class AlwaysValid implements ElectoralOrganism {
    private byte[] si = {1,1};
    private boolean signature=false;
    @Override
    public boolean canVote(Nif nif){
        return true;
    }

    @Override
    public void disableVoter(Nif nif) {
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) throws NoSignatureException {
        signature=true;
        return new DigitalSignature(si);


    }
}
