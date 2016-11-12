package io;

import exception.InvalidTriangleException;
import model.Row;
import model.Triangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

/**
 * Tests for the TriangleLoader file IO and triangle creation.
 */
public class TriangleLoaderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TriangleLoader triangleLoader;
    private FileLoader fileLoader;

    private static final String TEST_FILENAME = "test-filename";

    @Before
    public void setUp() {
        fileLoader = Mockito.mock(FileLoader.class);
        triangleLoader = new TriangleLoader(fileLoader);
    }

    @Test
    public void canLoadTriangleWithThreeLines() throws FileNotFoundException {
        configureFileLoader(TEST_FILENAME, "1", "2 3", "4 5 6");

        Triangle triangle = triangleLoader.loadFile(TEST_FILENAME);

        assertEquals(3, triangle.rows().size());
        assertRowContains(triangle.rows().get(0), 1);
        assertRowContains(triangle.rows().get(1), 2, 3);
        assertRowContains(triangle.rows().get(2), 4, 5, 6);
    }

    @Test
    public void loadTriangleWithFloatThrowsInvalidTriangleException() throws FileNotFoundException {
        configureFileLoader(TEST_FILENAME, "1.5");

        expectedException.expect(InvalidTriangleException.class);
        triangleLoader.loadFile(TEST_FILENAME);
    }

    @Test
    public void canLoadFromRealFile() throws FileNotFoundException {
        // An integration test to verify that the file loader and triangle loader can cooperate
        // Use a real file loader
        triangleLoader = new TriangleLoader(new FileLoader());

        Triangle triangle = triangleLoader.loadFile("triangle-4-rows.txt");

        assertEquals(4, triangle.rows().size());
        assertRowContains(triangle.rows().get(0), 3);
        assertRowContains(triangle.rows().get(1), 7, 4);
        assertRowContains(triangle.rows().get(2), 2, 4, 6);
        assertRowContains(triangle.rows().get(3), 8, 5, 9, 3);
    }

    private void configureFileLoader(String filename, String... lines) throws FileNotFoundException {
        List<String> fileContent = Arrays.asList(lines);
        when(fileLoader.getFileContents(eq(filename))).thenReturn(fileContent);
    }

    private void assertRowContains(Row row, int... pointValues) {
        assertEquals(pointValues.length, row.points().size());
        for (int i = 0; i < pointValues.length; i++) {
            assertEquals(pointValues[i], row.points().get(i).value());
        }
    }
}