package test;


import code.IntegerBreak;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntegerBreakParameterTest {

    int input;
    int expectedOutput;

    IntegerBreak.Solution solution;

    @Before
    public void before() {
        solution = new IntegerBreak.Solution();
    }

    public IntegerBreakParameterTest(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Integer[]> inputMethod() {
        final List<Integer[]> array = new ArrayList<>();
        array.add(new Integer[]{3,3});
        array.add(new Integer[]{4,4});
        array.add(new Integer[]{5,6});

        return array;
    }

    @Test
    public void integerBreakTestings() {
        assertEquals(expectedOutput, solution.integerBreak(input) );
    }

}
