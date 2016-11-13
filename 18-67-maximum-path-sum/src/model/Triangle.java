package model;

import exception.InvalidTriangleException;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a number triangle composed of N rows, of size 1 - N.
 */
public class Triangle {

    private final List<Row> rows;

    private static final int MINIMUM_ROWS = 2;

    /**
     * Construct a triangle from a list of rows.
     * There must be at least two rows for a valid triangle and they must incerase uniformly in size.
     * @param rows the list of rows to make into a triangle
     */
    public Triangle(List<Row> rows) {
        if (rowsAreValid(rows)) {
            this.rows = new ArrayList<>(rows);
        } else {
            throw new InvalidTriangleException(
                    "Triangle must be made of at least one row in sequential size order from 1 - N");
        }
    }

    /**
     * Get the size of the triangle (i.e. number of rows).
     * @return triangle size
     */
    public int size() {
        return this.rows.size();
    }

    /**
     * Get a specific row by index
     * @param index index of the row to return
     * @return row
     */
    public Row row(int index) {
        return this.rows.get(index);
    }

    private boolean rowsAreValid(List<Row> rows) {
        if (rows.size() < MINIMUM_ROWS) {
            // Must have at least two rows
            return false;
        }
        int rowCounter = 1;
        for (Row row : rows) {
            // Validate that the row size increases by one each row
            if (row.points().size() != rowCounter) {
                return false;
            }
            rowCounter++;
        }
        return true;
    }
}
