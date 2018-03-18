package pl.polsl.StatCalc.view;

import pl.polsl.StatCalc.model.Model;
import pl.polsl.StatCalc.model.ModelHolder;

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
        final Scanner inputUserNumbers = new Scanner(System.in);
        System.out.println("\n\n---STATISTICS ---\nHi " + argument + "!\nEnter numbers divided by comma\nfor example:6,5,3 WITHOUT WHITESPACES\nand hit enter");
        if (inputUserNumbers.hasNext(Pattern.compile("^\\d*(,\\d*)*$"))) {
            String inputNumbers = inputUserNumbers.nextLine();
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
        System.out.println("\nYour input was: " + model.getUserInput() + "\nAverage: " + model.getAverage() +
                "\nMedian: " + model.getMedian() + "\nStandard Deviation: " + model.getStdDev() + "\nVariance: " +
                model.getVariance());
    }

    /**
     * Iterates though modelHolder and prints models
     * @param modelHolder class holding list of models
     */
    public void print(ModelHolder modelHolder){
        for (Object model: modelHolder.listofgen) {
            System.out.println("-----------------");
            if (model instanceof Model){
                print((Model) model);
            }
        }
    }

    /**
     * Warning message for no input provided
     */
    public void print() {
        System.out.println("Couldn't initialize!\nWrong input!");
    }

    /**
     * Takes input from user, must be int
     * @return for proper answer 1 or 2, for every other 0
     */
    public int askForNext() {
        System.out.println("[1] Put values in\n" +
                "[2] Print all\n" +
                "[0] Exit");
        int answer = inputReader.nextInt();
        if (answer != 1 || answer != 2){
            return answer;
        } else {
            return 0;
        }
    }

    /**
     * Displays ending message to the user
     */
    public void endMessage(){
        System.out.println("\nThat's all for today!\n");
    }
}
