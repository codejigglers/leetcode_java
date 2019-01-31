package test;

import code.IntegerBreak;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerBreakTest {

    IntegerBreak.Solution solution;

    @Before
    public void before() {
        solution = new IntegerBreak.Solution();
    }

    @Test
    public void integerBreakTesting() {
        int input = 3;
        int expected = 2;
        assertEquals(expected, solution.integerBreak(input) );
    }


}