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
     * The size of the row (i.e. number of points)
     * @return row size
     */
    public int size() {
        return this.points.size();
    }


    /**
     * Get a point at a specified index in the row
     * @param index index in the row to obtain point for
     * @return point
     */
    public Point point(int index) {
        return this.points.get(index);
    }
}
