package pl.polsl;

import pl.polsl.StatCalc.model.Model;
import pl.polsl.StatCalc.view.*;

public class Main {

    public static void main(String[] args) {
        View view = new View();

        String numbersString = view.readNumbersToString();

        if(numbersString != null && !numbersString.isEmpty()){
            Model model = new Model(numbersString);
            view.print(model);
        } else {
            view.print();
        }
    }
}
