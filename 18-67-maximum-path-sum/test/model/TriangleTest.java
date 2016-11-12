package model;

import exception.InvalidTriangleException;
import model.Point;
import model.Row;
import model.Triangle;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Triangle class cover immutabilty, validity, behaviour.
 */
public class TriangleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canConstructTriangleWithValidRows() {
        Triangle triangle = new Triangle(makeRows(1, 2, 3));
        assertEquals(3, triangle.rows().size());
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
        assertEquals(2, triangle.rows().size());
    }

    @Test
    public void triangleIsImmutableByRowsMethod() {
        Triangle triangle = new Triangle(makeRows(1, 2));

        expectedException.expect(UnsupportedOperationException.class);
        triangle.rows().clear();
    }

    private Row makeRowOfSize(int length) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            points.add(new Point(i));
        }
        return new Row(points);
    }

    private List<Row> makeRows(int... rowSizes) {
        List<Row> rows = new ArrayList<>();
        for (int size : rowSizes) {
            rows.add(makeRowOfSize(size));
        }
        return rows;
    }
}