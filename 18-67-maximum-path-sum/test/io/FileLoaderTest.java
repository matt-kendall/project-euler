package io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the file loader can read from disk correctly and handle exceptions.
 */
public class FileLoaderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private FileLoader fileLoader;

    @Before
    public void setUp() {
        fileLoader = new FileLoader();
    }

    @Test
    public void invalidFileNameThrowsFileNotFoundException() throws FileNotFoundException {
        expectedException.expect(FileNotFoundException.class);
        fileLoader.getFileContents("file-does-not-exist.txt");
    }

    @Test
    public void canLoadFile() throws FileNotFoundException {
        List<String> lines = fileLoader.getFileContents("triangle-4-rows.txt");
        assertEquals(4, lines.size());
        assertEquals(lines.get(0), "3");
        assertEquals(lines.get(1), "7 4");
        assertEquals(lines.get(2), "2 4 6");
        assertEquals(lines.get(3), "8 5 9 3");
    }
}