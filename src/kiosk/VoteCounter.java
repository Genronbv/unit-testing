package kiosk;

import data.Party;

import java.util.*;

/**
 * A class that represents the result in an election site
 */
public class VoteCounter {

    private int countNull = 0;
    private int countBlank = 0;
    private int countVotes = 0;

    public VoteCounter(Set<Party> Parties) {

    }
    public void countParty(Party party){

    }
    public void countNull() { }
    public void countVotes() {}
    public void countBlank() {}
    public void scrutinize(Party party){

    }
    public int getVotesFor(Party party) {return 0;}
    public int getNulls() { return this.countNull; }
    public int getBlanks() { return this.countBlank; }
    public int getTotal() { return this.countNull + this.countVotes + this.countBlank; }
}
