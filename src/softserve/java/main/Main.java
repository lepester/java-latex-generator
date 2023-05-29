package softserve.java.main;

import java.util.List;

/**
 * The softserve.java.main.Main class is the entry point of the program.
 * It demonstrates the usage of the softserve.java.main.LatexWriter class to generate LaTeX content and save it to a file.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        LatexWriter latexWriter = new LatexWriter();

        // Adding title
        latexWriter.addTitle("My liked and disliked things ");

        // Adding list of favorite animals
        latexWriter.addText("List of favorite favoritedAnimals:");
        List<String> favoritedAnimals = List.of("Parrots", "Hippo", "Fox", "Rabbit", "Wolf", "Cat");
        latexWriter.addAnimalList(favoritedAnimals);

        // Adding list of disliked animals
        latexWriter.addText("Animals which I dislike:");
        List<String> hatedAnimals = List.of("Lion", "Elephant", "Tiger", "Giraffe", "Monkey", "Dog");
        latexWriter.addAnimalList(hatedAnimals);

        // Adding things I like
        latexWriter.addText("Things I Like:");
        latexWriter.addLink("Youtube", "https://www.youtube.com/");
        latexWriter.addLink("MyAnimeList", "https://myanimelist.net/");

        // Adding things I dislike
        latexWriter.addText("Things I dislike:");
        latexWriter.addLink("Rusnya1", "https://en.wikipedia.org/wiki/Russia");
        latexWriter.addLink("Rusnya2", "https://en.wikipedia.org/wiki/Russians");

        // Saving the generated LaTeX content to a file
        latexWriter.saveToFile("output/thingsILike&Hate.tex");
    }
}
