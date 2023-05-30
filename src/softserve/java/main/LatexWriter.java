package softserve.java.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The softserve.java.main.LatexWriter class provides functionality to generate LaTeX content and save it to a file.
 */
public class LatexWriter {
    protected StringBuilder latexContent;

    /**
     * Constructs a new softserve.java.main.LatexWriter instance.
     * Initializes the LaTeX content with the necessary document class and package.
     */
    public LatexWriter() {
        latexContent = new StringBuilder();
        latexContent.append("\\documentclass{article}\n");
        latexContent.append("\\usepackage{hyperref}\n");
        latexContent.append("\\begin{document}\n");
    }

    /**
     * Adds a text paragraph to the LaTeX content.
     *
     * @param text The text to be added as a paragraph.
     */
    public void addText(String text) {
        latexContent.append("\\par\n");
        latexContent.append(text);
        latexContent.append("\n");

    }

    /**
     * Adds a hyperlink to the LaTeX content.
     *
     * @param text The display text of the hyperlink.
     * @param url  The URL to be linked.
     */
    public void addLink(String text, String url) {
        latexContent.append("\\href{")
                .append(url)
                .append("}{")
                .append(text)
                .append("}"); // Создаем гиперссылку с помощью команды \href{}
        latexContent.append("\n");
    }

    /**
     * Adds a title to the LaTeX document.
     *
     * @param title The title of the document.
     */
    public void addTitle(String title) {
        latexContent.append("\\title{")
                .append(title)
                .append("}\n");
        latexContent.append("\\maketitle\n");
    }

    /**
     * Adds a list of animals as an itemized list to the LaTeX content.
     *
     * @param animals The list of animals.
     */
    public void addAnimalList(List<String> animals) {
        latexContent.append("\\begin{itemize}\n");
        for (String animal : animals) {
            latexContent.append("\\item ")
                    .append(animal)
                    .append("\n");
        }
        latexContent.append("\\end{itemize}\n");
        latexContent.append("\\par\n");
    }

    /**
     * Writes the LaTeX content to a file.
     *
     * @param filePath The path of the file to save the LaTeX content.
     */
    public void writeToFile(String filePath) {
        EmptyDirectory.checkAndClearDirectory(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(latexContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the LaTeX content to a file, including the necessary closing tags.
     * Additionally, checks if the directory already contains more than 10 files and clears it if necessary.
     * Prints a success message after the file is generated.
     *
     * @param filePath The path of the file to save the LaTeX content.
     */
    public void saveToFile(String filePath) {
        latexContent.append("\\end{document}");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writeToFile(filePath);
            writer.write(latexContent.toString());
            System.out.println("File successfully generated to project's directory: \n" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
