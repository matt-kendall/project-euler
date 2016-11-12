package model;

import exception.EmptyRowException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents one row of the Triangle.
 */
public class Row {

    private final List<Point> points;

    /**
     * Create a new Row from a list of points.
     * @param points points in the row
     */
    public Row(List<Point> points){
        if (points.size() > 0) {
            this.points = Collections.unmodifiableList(new ArrayList<>(points));
        } else {
            throw new EmptyRowException();
        }
    }

    /**
     * Returns an unmodifiable view on the list of points which make up this row.
     * @return points in this row
     */
    public List<Point> points() {
        return this.points;
    }
}
