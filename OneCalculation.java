package simpleCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class OneCalculation extends StartCalculator {

    private BigDecimal firstNumber, secondNumber, result;
    private String calculation;

    BigDecimal getResult() {
        return result;
    }

    void askUserForFirstNumber() {
        Scanner userNumbers = new Scanner(System.in);

        System.out.print("Please enter first number: ");

        if (!userNumbers.hasNextBigDecimal()) {
            System.out.println("That's not a number.");
            askUserForFirstNumber();
        } else
            firstNumber = userNumbers.nextBigDecimal();
        askUserForOperator();
    }


    private void askUserForOperator() {
        Scanner userCalculation = new Scanner(System.in);

        System.out.print("Please enter what you want to do: add ( + ), subtract ( - ), multiply ( * ), divide ( / ): ");
        calculation = userCalculation.next();

        switch (calculation) {
            case "add":
            case "+":
                askUserForSecondNumber();
                break;
            case "subtract":
            case "-":
                askUserForSecondNumber();
                break;
            case "multiply":
            case "*":
                askUserForSecondNumber();
                break;
            case "divide":
            case "/":
                askUserForSecondNumber();
                break;
            default:
                System.out.println("That's not an operator.");
                askUserForOperator();
        }
    }

    private void askUserForSecondNumber() {
        Scanner userNumbers = new Scanner(System.in);

        System.out.print("Please enter second number: ");

        if (!userNumbers.hasNextBigDecimal()) {
            System.out.println("That's not a number.");
            askUserForSecondNumber();
        } else {
            secondNumber = userNumbers.nextBigDecimal();
            resultOfCalculation();
        }
    }

    private void resultOfCalculation() {
        switch (calculation) {
            case "add":
            case "+":
                result = firstNumber.add(secondNumber);
                System.out.println(firstNumber + " " + calculation + " " + secondNumber + " = " + result);
                break;
            case "subtract":
            case "-":
                result = firstNumber.subtract(secondNumber);
                System.out.println(firstNumber + " " + calculation + " " + secondNumber + " = " + result);
                break;
            case "multiply":
            case "*":
                result = firstNumber.multiply(secondNumber);
                System.out.println(firstNumber + " " + calculation + " " + secondNumber + " = " + result);
                break;
            case "divide":
            case "/":
                if (secondNumber.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.println("You can't divide by zero.");
                    askUserForSecondNumber();
                } else {
                    result = firstNumber.divide(secondNumber, 3, RoundingMode.HALF_UP);
                    System.out.println(firstNumber + " " + calculation + " " + secondNumber + " = " + result);
                }
        }
    }
}
