package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages file loading operations.
 */
public class FileLoader {

    /**
     * Get the contents of a file as a list of strings.
     * This will load all the file into memory at one time.
     * @param fileName file name to open
     * @return list of strings for each line in the file
     * @throws FileNotFoundException if the file could not be located
     */
    public List<String> getFileContents(String fileName) throws FileNotFoundException {
        File file = openFile(fileName);
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }

    private File openFile(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new FileNotFoundException();
        }
        return new File(resource.getFile());
    }
}
