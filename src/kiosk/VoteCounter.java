package kiosk;

import data.Party;
import exceptions.NoPartyException;

import java.util.*;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {

    private Map<Party, Integer> validParties = new HashMap<>();
    private int countNull = 0;
    private int countBlank = 0;
    private int countVotes = 0;


    public VoteCounter(Set<Party> Parties) {
        for (Party party: Parties){
            validParties.put(party,0);
        }


    }
    public void countParty(Party party) throws NoPartyException {
        if (this.validParties.containsKey(party)){
            int votesForParty = this.validParties.get(party);
            this.validParties.replace(party,votesForParty+1);
            countVotes();
        }
        else{
            throw new NoPartyException();}
    }
    private void countNull() { this.countNull++;}
    private void countVotes() {this.countVotes++;}
    private void countBlank() { this.countBlank++; }
    public void scrutinize(Party party) throws NoPartyException {
        if (party.getName().equals("null")){ countNull();}
        else if (party.getName().equals("")){ countBlank();}
        else {countParty(party);}
    }
    public int getVotesFor(Party party) { return this.validParties.get(party); }
    public int getNulls() { return this.countNull; }
    public int getBlanks() { return this.countBlank; }
    public int getTotal() { return this.countNull + this.countVotes + this.countBlank; }
}
