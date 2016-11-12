package model;

/**
 * Represents a point in a number triangle.
 */
public class Point {

    private final int value;

    /**
     * Create new point of specified value.
     * @param value value of point
     */
    public Point(int value) {
        this.value = value;
    }

    /**
     * The numerical value of this point.
     * @return point value
     */
    public int value() {
        return value;
    }
}
