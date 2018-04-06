package simpleCalculator;

import java.util.Scanner;

class StartCalculator {

    private int numberOfEquations;

    void numberOfCalculations() throws InterruptedException {
        Scanner userNumberOfEquations = new Scanner(System.in);
        Scanner miniGameQuestion = new Scanner(System.in);

        System.out.print("If you want to close Primordial Calculator press \"0\".\nPlease enter how many equations you want to do: ");

        if (!userNumberOfEquations.hasNextInt()) {
            System.out.println("That's not an integer.");
            numberOfCalculations();
        } else {
            numberOfEquations = userNumberOfEquations.nextInt();

            if (numberOfEquations == 4) {
                System.out.print("I see you might be interested in playing mini game, are you? (Y/N): ");
                if ((miniGameQuestion.hasNext("y") || miniGameQuestion.hasNext("Y"))) {
                    MiniGameFuturama miniGameFuturama = new MiniGameFuturama();
                    miniGameFuturama.miniGameFuturama();
                } else {
                    System.out.println("Well... I see you are not interested, so here's a Primordial Calculator:\n");
                    doNotStartMiniGame();
                }
            } if (numberOfEquations == 0) {
                System.out.println("\nThank you for using Primordial Calculator.");
                System.exit(0);
            } else {
                doNotStartMiniGame();
            }
        }
        userNumberOfEquations.close();
        miniGameQuestion.close();
    }

    private void doNotStartMiniGame() throws InterruptedException {

        int numberOfOperations;

        Scanner userNumberOfOperations = new Scanner(System.in);

        int i;

        for (i = 0; i < numberOfEquations; i++) {
            System.out.print("Please enter how many operations in this equation you want to do (1-3): ");
            if (!userNumberOfOperations.hasNextInt()) {
                System.out.print("That's not an integer.\n");
                doNotStartMiniGame();
            } else {
                numberOfOperations = userNumberOfOperations.nextInt();
                if (numberOfOperations == 1) {
                    OneCalculation oneCalculation = new OneCalculation();
                    oneCalculation.askUserForFirstNumber();
                }
                if (numberOfOperations == 2) {
                    TwoCalculations twoCalculations = new TwoCalculations();
                    twoCalculations.askUserForFirstNumber();
                    twoCalculations.askUserForSecondOperator();
                }
                if (numberOfOperations == 3) {
                    ThreeCalculations threeCalculations = new ThreeCalculations();
                    threeCalculations.askUserForFirstNumber();
                    threeCalculations.askUserForSecondOperator();
                    threeCalculations.askUserForThirdOperator();
                }
                if (numberOfOperations > 3) {
                    System.out.print("Maximum number of operations is 3.\n");
                    doNotStartMiniGame();
                }
                if (numberOfOperations < 1) {
                    System.out.println("\nThank you for using Primordial Calculator.");
                    System.exit(0);
                }
            }
        }
        if (i == numberOfEquations) {
            askUserToRestartCalculator();
        }
        userNumberOfOperations.close();
    }

    void askUserToRestartCalculator() throws InterruptedException {
        System.out.print("\nNow, what you want to do? \nDo you want to run Primordial Calculator (Y/N): ");
        Scanner runCalculator = new Scanner(System.in);
        if (runCalculator.hasNext("y") || runCalculator.hasNext("Y")) {
            numberOfCalculations();
        } else {
            System.out.println("\nThank you for using Primordial Calculator.");
            System.exit(0);
        }
        runCalculator.close();
    }
}