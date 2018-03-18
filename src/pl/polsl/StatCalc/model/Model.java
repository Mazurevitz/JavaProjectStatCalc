package pl.polsl.StatCalc.model;

import java.util.*;

public class Model {

    private int[] inputList;
    private String inputListString;
    private double average;
    private double median;
    private double stdDev;

    public double getAverage(){
        return average;
    }

    public double getMedian(){
        return median;
    }

    public double getStdDev(){
        return stdDev;
    }

    public String getUserInput(){
        return inputListString;
    }

    /**
     * Used to calculate average, median and standard deviation
     * @param inputList takes input from user in form: '1,2,3...'
     */
    public Model(String inputList){
        this.inputListString = inputList;
        this.inputList = Arrays.stream(inputList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
         average = calcAverage(this.inputList);
         median = calcMedian(this.inputList);
         stdDev = calcStdDev(this.inputList);

    }

    private double calcAverage(int[] numArray){
        double average = 0;
        for (int num : numArray) {
            average+=num;
        }
        return average/numArray.length;
    }

    private double calcMedian(int[] numArray) {
        Arrays.sort(numArray);
        if (numArray.length % 2 == 0) // check if length is odd or even
            return ((double)numArray[numArray.length/2] +
                    (double)numArray[numArray.length/2 - 1]);
        else
            return (double)numArray[numArray.length/2];
    }

    private double calcVariance(int[] numArray){
        double average = calcAverage(numArray);
        double sumOfSquares = 0;
        for (int num : numArray) {
            sumOfSquares+=Math.pow(num-average, 2);
        }
        return sumOfSquares/numArray.length;
    }

    private double calcStdDev(int[] numArray) {
        return Math.sqrt(calcVariance(numArray));
    }
}