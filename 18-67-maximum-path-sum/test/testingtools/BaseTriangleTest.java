package testingtools;

import model.Point;
import model.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains common functionality used in tests.
 */
public class BaseTriangleTest {

    protected Row makeRowOfSize(int length) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            points.add(new Point(i));
        }
        return new Row(points);
    }

    protected List<Row> makeRows(int... rowSizes) {
        List<Row> rows = new ArrayList<>();
        for (int size : rowSizes) {
            rows.add(makeRowOfSize(size));
        }
        return rows;
    }
}
