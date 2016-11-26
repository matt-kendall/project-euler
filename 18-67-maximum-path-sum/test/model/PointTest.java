package model;

import model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Point class.
 */
public class PointTest {

    @Test
    public void canCreatePoint() {
        Point point = new Point(123);
        assertEquals(123, point.value());
    }

}