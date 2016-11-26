package model;

import exception.EmptyRowException;
import model.Point;
import model.Row;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for immutability and behaviour of the Row class.
 */
public class RowTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canCreateRowWithOnePoint() {
        new Row(Collections.singletonList(
                new Point(1)
        ));
    }

    @Test
    public void canGetPoints() {
        Row row = new Row(Arrays.asList(
                new Point(1),
                new Point(2)
        ));
        assertEquals(2, row.size());
        assertEquals(1, row.point(0).value());
        assertEquals(2, row.point(1).value());
    }

    @Test
    public void createRowWithZeroPointsThrowsInvalidRowException() {
        // A row with zero points doesn't make sense
        expectedException.expect(EmptyRowException.class);
        new Row(Collections.emptyList());
    }

    @Test
    public void rowIsImmutableByConstructor() {
        // Verify that altering the list originally passed to the Row constructor does not mutate the Row.
        List<Point> points = new ArrayList<>();
        points.add(new Point(1));

        Row row = new Row(points);

        points.clear(); // Mutate the original list
        assertEquals(1, row.size());
    }
}