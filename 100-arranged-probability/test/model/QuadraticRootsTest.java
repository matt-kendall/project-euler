package model;

import org.junit.Test;
import testingtools.TestBase;

import static org.junit.Assert.*;

/**
 * Tests that the QuadraticRoots correctly identify lower and upper roots.
 */
public class QuadraticRootsTest extends TestBase {


    @Test
    public void canGetCorrectRootsWhenRoot1LessThanRoot2() {
        QuadraticRoots roots = new QuadraticRoots(-123.5, 100.0);
        assertEquals(-123.5, roots.lower(), TEST_DELTA);
        assertEquals(100.0, roots.upper(), TEST_DELTA);
    }

    @Test
    public void canGetCorrectRootsWhenRoot1GreaterThanRoot2() {
        QuadraticRoots roots = new QuadraticRoots(199, 7.5);
        assertEquals(7.5, roots.lower(), TEST_DELTA);
        assertEquals(199, roots.upper(), TEST_DELTA);
    }

    @Test
    public void canGetCorrectRootsWhenRoot1EqualsRoot2() {
        QuadraticRoots roots = new QuadraticRoots(0, 0);
        assertEquals(0, roots.lower(), TEST_DELTA);
        assertEquals(0, roots.upper(), TEST_DELTA);
    }
}