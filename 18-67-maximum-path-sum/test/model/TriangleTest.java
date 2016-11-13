package model;

import exception.InvalidTriangleException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import testingtools.BaseTriangleTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Triangle class cover immutabilty, validity, behaviour.
 */
public class TriangleTest extends BaseTriangleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canConstructTriangleWithValidRows() {
        Triangle triangle = new Triangle(makeRows(1, 2, 3));
        assertEquals(3, triangle.size());
    }

    @Test
    public void constructingTriangleMissingFirstRowThrowsInvalidTriangleException() {
        expectedException.expect(InvalidTriangleException.class);
        new Triangle(makeRows(2, 3));
    }

    @Test
    public void constructingTriangleWithMissingRowsThrowsInvalidTriangleException() {
        expectedException.expect(InvalidTriangleException.class);
        new Triangle(makeRows(1, 3));
    }

    @Test
    public void constructingTriangleWithRowsOutOfOrderThrowsInvalidTriangleException() {
        expectedException.expect(InvalidTriangleException.class);
        new Triangle(makeRows(1, 3, 2));
    }

    @Test
    public void constructingTriangleWithOnlyOneRowThrowsInvalidTriangleException() {
        expectedException.expect(InvalidTriangleException.class);
        new Triangle(makeRows(1));
    }

    @Test
    public void triangleIsImmutableByConstructor() {
        List<Row> rows = makeRows(1, 2);
        Triangle triangle = new Triangle(rows);

        rows.clear(); // Mutate the rows list
        assertEquals(2, triangle.size());
    }

    @Test
    public void canGetRowByIndex() {
        List<Row> rows = makeRows(1, 2);
        Triangle triangle = new Triangle(rows);

        assertEquals(2, triangle.row(1).points().size());
    }
}