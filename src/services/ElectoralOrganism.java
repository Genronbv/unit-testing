package services;

import data.DigitalSignature;
import data.Nif;
import data.Party;
import exceptions.NoSignatureException;

/**
 * External service for signing votes and manage the electoral roll
 */
public interface ElectoralOrganism {
    boolean canVote(Nif nif);
    void disableVoter(Nif nif);
    DigitalSignature askForDigitalSignature(Party party) throws NoSignatureException;
}
