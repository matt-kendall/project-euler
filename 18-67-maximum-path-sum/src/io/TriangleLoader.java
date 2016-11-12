package io;

import exception.InvalidTriangleException;
import model.Point;
import model.Row;
import model.Triangle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads a Triangle from a text file.
 */
public class TriangleLoader  {

    private final FileLoader fileLoader;

    /**
     * Create a new Triangle Loader with a given FileLoader.
     * @param fileLoader file loader to open files with
     */
    public TriangleLoader(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    /**
     * Load a triangle from a given file.
     * The file should contain rows of uniformly increasing size with points separated by whitespace, e.g.:
     * 1
     * 2 3
     * 4 5 6
     * @param fileName the name of the file to load
     * @return loaded triangle
     */
    public Triangle loadFile(String fileName) throws FileNotFoundException {
        List<String> lines = fileLoader.getFileContents(fileName);
        List<Row> rows = new ArrayList<>();
        for (String line : lines) {
            rows.add(getRow(line));
        }
        return new Triangle(rows);
    }

    private Row getRow(String line) {
        List<Point> points = new ArrayList<>();
        for (String str : line.split("\\s+")) {
            int pointValue;
            try {
                pointValue = Integer.valueOf(str);
            } catch (NumberFormatException ex) {
                throw new InvalidTriangleException(
                        String.format("All values in a triangle must be an integer - exception was: %s",
                                ex.getMessage()));
            }
            Point point = new Point(pointValue);
            points.add(point);
        }
        return new Row(points);
    }
}
