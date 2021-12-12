package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "task.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String[][] tasks;

    public static void main(String[] args) throws IOException {
        loadDataToTab(FILE_NAME);
        printOptions(OPTIONS);
    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);
        for (String option : tab) {
            System.out.println(option);
        }
    }

    public static String[][] loadDataToTab(String filename) throws IOException {
        Path dir = Paths.get(filename);
        if (!Files.exists(dir)) {
            System.out.println("Files not exist");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(dir);    // metoda loadData... do ponownej analizy zaczynając od List!!
            tab = new String[strings.size()][strings.get(0).split(",").length];  // czy można użyć klasy Scanner + while i zapisać do tab??

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }
}
