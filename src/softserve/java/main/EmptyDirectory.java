package softserve.java.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * The softserve.java.main.EmptyDirectory class provides utility methods to check and clear a directory if it contains more than a certain number of files.
 * It extends the softserve.java.main.LatexWriter class.
 */
public class EmptyDirectory extends LatexWriter {
    /**
     * Checks the number of files in the directory containing the specified file path.
     * If the file count is greater than 10, clears the directory by deleting all files.
     *
     * @param filePath The file path used to determine the directory.
     */
    public static void checkAndClearDirectory(String filePath) {
        File file = new File(filePath);
        String parentDir = file.getParent();
        int fileCount = getFileCountInDirectory(parentDir);

        if (fileCount > 10) {
            try {
                Files.walk(Path.of(parentDir))
                        .filter(Files::isRegularFile)
                        .forEach(p -> {
                            try {
                                Files.delete(p);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Counts the number of files in the specified directory.
     *
     * @param directoryPath The path of the directory.
     * @return The number of files in the directory.
     */
    private static int getFileCountInDirectory(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Path.of(directoryPath))) {
            return (int) paths.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
