import org.junit.Test;

import static org.junit.Assert.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 7. 22..
 */
public class ATMTest {

    ATM atm = new ATM();

    @Test
    public void solution() {
        assertEquals(32, atm.solution(5, new int[]{3, 1, 4, 3, 2}));
        assertEquals(10, atm.solution(3, new int[]{3, 2, 1}));
    }

}