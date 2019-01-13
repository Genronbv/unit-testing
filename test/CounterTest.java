import data.*;
import exceptions.NoNameException;
import exceptions.NoPartyException;
import kiosk.*;

import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {
    private Party nulll;
    private Party blank;
    private Party party;
    private VoteCounter vc;

    @BeforeEach
    void initAll() throws NoNameException {
        nulll = new Party("null");
        blank = new Party("");
        party = new Party("pp");
        vc = new VoteCounter(new HashSet<>(Arrays.asList(new Party("pp"), new Party("psoe"), new Party("ERC"))));
    }


    @Test
    public void voteNullTest() throws NoPartyException {
        vc.scrutinize(nulll);
        assertEquals(1,vc.getNulls());
    }

    @Test
    public void voteBlankTest() throws NoPartyException {
        vc.scrutinize(blank);
        assertEquals(1,vc.getBlanks());
    }



    @Test
    public void voteCounterTest() throws NoPartyException {
        vc.scrutinize(party);
        assertEquals(1,vc.getVotesFor(party));
    }

    @Test
    public void voteTest() throws NoPartyException {
        vc.scrutinize(party);
        vc.scrutinize(blank);
        vc.scrutinize(nulll);
        assertEquals(3,vc.getTotal());
    }
    @Test
    public void invalidParty() {
        Throwable invalidParty = assertThrows(NoPartyException.class,
                ()->{vc.countParty(new Party("mike"));});



    }

    @AfterEach
    public void teardown(){}

}