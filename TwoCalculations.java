package simpleCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class TwoCalculations extends OneCalculation {

    private BigDecimal thirdNumber, secondResult;

    BigDecimal getSecondResult() {
        return secondResult;
    }

    void askUserForSecondOperator() {
        Scanner userCalculation = new Scanner(System.in);

        System.out.print("Please enter what you want to do: add ( + ), subtract ( - ), multiply ( * ), divide ( / ): ");
        calculation = userCalculation.next();

        switch (calculation) {
            case "add":
            case "+":
                askUserForThirdNumber();
                break;
            case "subtract":
            case "-":
                askUserForThirdNumber();
                break;
            case "multiply":
            case "*":
                askUserForThirdNumber();
                break;
            case "divide":
            case "/":
                askUserForThirdNumber();
                break;
            default:
                System.out.println("That's not an operator.");
                askUserForSecondOperator();
        }
    }

    private void askUserForThirdNumber() {
        Scanner userNumbers = new Scanner(System.in);

        System.out.print("Please enter third number: ");
        if (!userNumbers.hasNextBigDecimal()) {
            System.out.println("That's not a number.");
            askUserForThirdNumber();
        } else {
            thirdNumber = userNumbers.nextBigDecimal();
            resultOfSecondCalculation();
        }
    }

    private void resultOfSecondCalculation() {
        switch (calculation) {
            case "add":
            case "+":
                secondResult = getResult().add(thirdNumber);
                System.out.println(getResult() + " " + calculation + " " + thirdNumber + " = " + secondResult);
                break;
            case "subtract":
            case "-":
                secondResult = getResult().subtract(thirdNumber);
                System.out.println(getResult() + " " + calculation + " " + thirdNumber + " = " + secondResult);
                break;
            case "multiply":
            case "*":
                secondResult = getResult().multiply(thirdNumber);
                System.out.println(getResult() + " " + calculation + " " + thirdNumber + " = " + secondResult);
                break;
            case "divide":
            case "/":
                if (thirdNumber.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("You can't divide by zero.");
                    askUserForThirdNumber();
                } else {
                    secondResult = getResult().divide(thirdNumber, 3, RoundingMode.HALF_UP);
                    System.out.println(getResult() + " " + calculation + " " + thirdNumber + " = " + secondResult);
                }
        }
    }
}