package pl.polsl.StatCalc.view;

import pl.polsl.StatCalc.model.Model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private final Scanner inputReader = new Scanner(System.in);

    public String readNumbersToString() {
        System.out.println("Enter numbers divided by comma\nfor example:6,5,3 WITHOUT WHITESPACES\nand hit enter");
        if (inputReader.hasNext(Pattern.compile("^\\d*(,\\d*)*$"))) {
            String inputNumbers = inputReader.nextLine();
            return inputNumbers;
        } else {
            return null;
        }
    }

    public void print(Model model) {
        System.out.println("Your input was: " + model.getUserInput() + "\nAverage: " + model.getAverage() +
                "\nMedian: " + model.getMedian() + "\nStandard Deviation: " + model.getStdDev());
    }

    public void print() {
        System.out.println("Couldn't initialize!\nWrong input!");
    }
}
