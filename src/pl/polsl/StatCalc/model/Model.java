package pl.polsl.StatCalc.model;

import java.util.*;

public class Model {

    private int[] inputList;
    private String inputListString;
    private double average;
    private double median;
    private double variance;
    private double stdDev;

    /**
     * @return Get average of the inputted numbers
     */
    public double getAverage(){
        return average;
    }

    /**
     * @return Get variance of the inputted numbers
     */
    public double getVariance(){
        return variance;
    }

    /**
     * @return Get median of the inputted numbers
     */
    public double getMedian(){
        return median;
    }

    /**
     * @return Get standard deviation of the inputted numbers
     */
    public double getStdDev(){
        return stdDev;
    }

    /**
     * @return Get inputted numbers by the user as a string
     */
    public String getUserInput(){
        return inputListString;
    }

    /**
     * Used to calculate average, median and standard deviation
     * @param inputList takes input from user as a String in form: '1,2,3...'
     */
    public Model(String inputList){
        this.inputListString = inputList;
        this.inputList = Arrays.stream(inputList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
         average = calcAverage(this.inputList);
         median = calcMedian(this.inputList);
         stdDev = calcStdDev(this.inputList);
         variance = calcVariance(this.inputList);
    }

    /**
     * Calculates average from array of integers
     * @param numArray array of integers from the user
     * @return calculated average in double
     */
    private double calcAverage(int[] numArray){
        double average = 0;
        for (int num : numArray) {
            average+=num;
        }
        return average/numArray.length;
    }

    /**
     * Calculates median from array of integers
     * @param numArray array of integers from the user
     * @return calculated median in double
     */
    private double calcMedian(int[] numArray) {
        Arrays.sort(numArray);
        if (numArray.length % 2 == 0) // check if length is odd or even
            return ((double)numArray[numArray.length/2] +
                    (double)numArray[numArray.length/2 - 1]);
        else
            return (double)numArray[numArray.length/2];
    }

    /**
     * Calculates variance from array of integers
     * @param numArray array of integers from the user
     * @return calculated variance in double
     */
    private double calcVariance(int[] numArray){
        double average = calcAverage(numArray);
        double sumOfSquares = 0;
        for (int num : numArray) {
            sumOfSquares+=Math.pow(num-average, 2);
        }
        return sumOfSquares/numArray.length;
    }

    /**
     * Calculates standard deviation from array of integers
     * @param numArray array of integers from the user
     * @return calculated variance in double
     */
    private double calcStdDev(int[] numArray) {
        return Math.sqrt(calcVariance(numArray));
    }
}