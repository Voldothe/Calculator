package simpleCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


class ThreeCalculations extends TwoCalculations {

    private BigDecimal fourthNumber;

    void askUserForThirdOperator() {
        Scanner userCalculation = new Scanner(System.in);

        System.out.print("Please enter what you want to do: add ( + ), subtract ( - ), multiply ( * ), divide ( / ): ");
        calculation = userCalculation.next();

        switch (calculation) {
            case "add":
            case "+":
                askUserForFourthNumber();
                break;
            case "subtract":
            case "-":
                askUserForFourthNumber();
                break;
            case "multiply":
            case "*":
                askUserForFourthNumber();
                break;
            case "divide":
            case "/":
                askUserForFourthNumber();
                break;
            default:
                System.out.println("That's not an operator.");
                askUserForThirdOperator();
        }
    }

    private void askUserForFourthNumber() {
        Scanner userNumbers = new Scanner(System.in);

        System.out.print("Please enter fourth number: ");
        if (!userNumbers.hasNextBigDecimal()) {
            System.out.println("That's not a number.");
            askUserForFourthNumber();
        } else {
            fourthNumber = userNumbers.nextBigDecimal();
            resultOfThirdCalculation();
        }
    }

    private void resultOfThirdCalculation() {
        BigDecimal thirdResult;

        switch (calculation) {
            case "add":
            case "+":
                thirdResult = getSecondResult().add(fourthNumber);
                System.out.println(getSecondResult() + " " + calculation + " " + fourthNumber + " = " + thirdResult);
                break;
            case "subtract":
            case "-":
                thirdResult = getSecondResult().subtract(fourthNumber);
                System.out.println(getSecondResult() + " " + calculation + " " + fourthNumber + " = " + thirdResult);
                break;
            case "multiply":
            case "*":
                thirdResult = getSecondResult().multiply(fourthNumber);
                System.out.println(getSecondResult() + " " + calculation + " " + fourthNumber + " = " + thirdResult);
                break;
            case "divide":
            case "/":
                if (fourthNumber.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("You can't divide by zero.");
                    askUserForFourthNumber();
                } else {
                    thirdResult = getSecondResult().divide(fourthNumber, 3, RoundingMode.HALF_UP);
                    System.out.println(getSecondResult() + " " + calculation + " " + fourthNumber + " = " + thirdResult);
                }
        }
    }
}