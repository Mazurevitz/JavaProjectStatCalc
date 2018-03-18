package pl.polsl;

import pl.polsl.StatCalc.model.Model;
import pl.polsl.StatCalc.model.ModelHolder;
import pl.polsl.StatCalc.view.*;

/**
 * @author Wojciech Mazur
 * @version r1
 */
public class Main {

    public static void main(String[] args) {
        View view = new View();
        ModelHolder modelHolder = new ModelHolder();
        String numbersString;
        int userChoice = 0;

        do {
            userChoice = view.askForNext();
            switch(userChoice) {
                case 1:
                    if (args.length != 0) { //cannot check args[0] if it's non existent
                        numbersString = view.readNumbersToString(args[0]); //sends name to the function
                    } else {
                        numbersString = view.readNumbersToString(); //if no initial argument, "unnknown user" is displayed
                    }

                    if (numbersString != null && !numbersString.isEmpty()) {
                        Model model = new Model(numbersString);
                        modelHolder.listofgen.add(model);
                        view.print(model);
                    } else {
                        view.print();
                    }
                    break;
                case 2:
                    view.print(modelHolder);
                    break;
                }
        } while (userChoice != 0);

        view.endMessage();
    }
}
