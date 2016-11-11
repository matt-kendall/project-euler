import exception.NotThreeDigitsException;
import number.NumberDecomposer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Tests that the NumberLetterCounter correctly identifies the number of letters in a given number.
 */
public class NumberLetterCounterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private NumberLetterCounter numberLetterCounter;

    @Before
    public void setUp() {
        NumberDecomposer numberDecomposer = new NumberDecomposer();
        numberLetterCounter = new NumberLetterCounter(numberDecomposer);
    }

    @Test
    public void numberNotThreeDigitsThrowsNotThreeDigitsException() throws NotThreeDigitsException {
        expectedException.expect(NotThreeDigitsException.class);
        numberLetterCounter.count(1000);
    }

    @Test
    public void testNumberOneGivesThreeLetters() throws NotThreeDigitsException {
        int count = numberLetterCounter.count(1);
        assertEquals(3, count);
    }

    @Test
    public void testNumberThirteenGivesEightLetters() throws NotThreeDigitsException {
        int count = numberLetterCounter.count(13);
        assertEquals(8, count);
    }

    @Test
    public void testNumberTwentyOneGivesNineLetters() throws NotThreeDigitsException {
        // 'Twenty-one' has nine letters because we don't count the hyphen
        int count = numberLetterCounter.count(21);
        assertEquals(9, count);
    }

    @Test
    public void testNumberSixHundredAndTwentyThreeGivesTwentyFourLetters() throws NotThreeDigitsException {
        // 'six hundred and twenty-three' has 24 letters because we don't count the hyphen or space
        int count = numberLetterCounter.count(623);
        assertEquals(24, count);
    }

    @Test
    public void testNumberThreeHundredAndFortyTwoGivesTwentyThreeLetters() throws NotThreeDigitsException {
        // example taken from https://projecteuler.net/problem=17
        int count = numberLetterCounter.count(342);
        assertEquals(23, count);
    }

    @Test
    public void testNumberOneHundredAndFifteenGivesTwentyLetters() throws NotThreeDigitsException {
        // example taken from https://projecteuler.net/problem=17
        int count = numberLetterCounter.count(115);
        assertEquals(20, count);
    }

    @Test
    public void testRangeFromOneToFiveGivesNineteenLetters() throws NotThreeDigitsException {
        // One -> 3
        // Two -> 3
        // Three -> 5
        // Four -> 4
        // Five -> 4
        // TOTAL = 19
        int count = numberLetterCounter.countRange(1, 5);
        assertEquals(19, count);
    }

    @Test
    public void testRangeFromTenToThirteenGivesTwentyThreeLetters() throws NotThreeDigitsException {
        // Ten -> 3
        // Eleven -> 6
        // Twelve -> 6
        // Thirteen -> 8
        // TOTAL = 23
        int count = numberLetterCounter.countRange(10, 13);
        assertEquals(23, count);
    }

    @Test
    public void testRangeFromOneToNineGivesThirtySixLetters() throws NotThreeDigitsException {
        // Data taken from http://www.mathblog.dk/project-euler-17-letters-in-the-numbers-1-1000/
        int count = numberLetterCounter.countRange(1, 9);
        assertEquals(36, count);
    }

    @Test
    public void testRangeFromTenToNineteenGivesSeventyLetters() throws NotThreeDigitsException {
        // Data taken from http://www.mathblog.dk/project-euler-17-letters-in-the-numbers-1-1000/
        int count = numberLetterCounter.countRange(10, 19);
        assertEquals(70, count);
    }

    @Test
    public void testRangeFromTwentyToNinetyNineGivesSevenHundredAndFortyEightLetters() throws NotThreeDigitsException {
        // Data taken from http://www.mathblog.dk/project-euler-17-letters-in-the-numbers-1-1000/
        int count = numberLetterCounter.countRange(20, 99);
        assertEquals(748, count);
    }

    @Test
    public void testRangeFromOneHundredToNineHundredAndNinetyNineGives20259Letters() throws NotThreeDigitsException {
        // Data taken from http://www.mathblog.dk/project-euler-17-letters-in-the-numbers-1-1000/
        int count = numberLetterCounter.countRange(100, 999);
        assertEquals(20259, count);
    }

    @Test
    public void testRangeMinGreaterThanMaxGivesZeroLetters() throws NotThreeDigitsException {
        int count = numberLetterCounter.countRange(10, 5);
        assertEquals(0, count);
    }
}