package kamal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class KamalTest {
    private String S, L;

    @Test
    void testOne() {
        S = "AGTC";
        L = "AGTCAGTC";

        assertEquals(2, Kamal.go(S, L));
        assertEquals(4, Kamal.goRemOneChar(S, L));
        assertEquals(2, Kamal.goAddOneChar(S, L));
    }

    @Test
    void testTwo() {
        S = "AAA";
        L = "AAAAAAAAAA";

        assertEquals(8, Kamal.go(S, L));
        assertEquals(9, Kamal.goRemOneChar(S, L));
        assertEquals(7, Kamal.goAddOneChar(S, L));
    }

    @Test
    void testFail() {
        S = "AGTC";
        L = "TTTTGGC";

        assertEquals(0, Kamal.go(S, L));
        assertEquals(0, Kamal.goRemOneChar(S, L));
        assertEquals(0, Kamal.goAddOneChar(S, L));
    }
}