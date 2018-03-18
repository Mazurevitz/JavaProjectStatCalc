package pl.polsl.StatCalc.view;

import pl.polsl.StatCalc.model.Model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private final Scanner inputReader = new Scanner(System.in);

    /**
     * Displays welcome message with input argument at the begging of the program
     * @param argument Name of the user
     * @return Numbers inputted by user as a String, otherwise null
     */
    public String readNumbersToString(String argument) {
        System.out.println("Hi " + argument + "!\nEnter numbers divided by comma\nfor example:6,5,3 WITHOUT WHITESPACES\nand hit enter");
        if (inputReader.hasNext(Pattern.compile("^\\d*(,\\d*)*$"))) {
            String inputNumbers = inputReader.nextLine();
            return inputNumbers;
        } else {
            return null;
        }
    }

    /**
     * Displays welcome message without default user name at the begging of the program
     * @return Numbers inputted by user as a String, otherwise null
     */
    public String readNumbersToString() {
        return readNumbersToString("unknown user");
    }

    /**
     * Displays final calculated statistics
     * @param model Previously constructed model with all the values
     */
    public void print(Model model) {
        System.out.println("Your input was: " + model.getUserInput() + "\nAverage: " + model.getAverage() +
                "\nMedian: " + model.getMedian() + "\nStandard Deviation: " + model.getStdDev() + "\nVariance: " +
                model.getVariance());
    }

    /**
     * Warning message for no input provided
     */
    public void print() {
        System.out.println("Couldn't initialize!\nWrong input!");
    }
}
