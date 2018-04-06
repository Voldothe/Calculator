package simpleCalculator;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

class MiniGameFuturama extends StartCalculator {

    void miniGameFuturama() throws InterruptedException {

        Scanner guessAnswer = new Scanner(System.in);
        System.out.print("\nWelcome to the Primordial Mini Game. We do hope you are familiar with Futurama... \nSo... Guess a number that I'm thinking of... \nIt's between one and three... \nSo, your answer is: ");
        int numberGuessed = guessAnswer.nextInt();
        if (numberGuessed == 4) {
            System.out.println("It's between 1 and 3, not including 1 or 3...");
            System.out.print("Let's try again... Number I'm thinking of is: ");
            if (guessAnswer.hasNext("m") || (guessAnswer.hasNext("M"))) {
                System.out.println("\nSuddenly you hear a voice coming from somewhere...");
                Thread.sleep(1000);
                System.out.println("Bender asks: \"...is this right answer?\"");
                Thread.sleep(2000);
                System.out.println("Yes, the number I was thinking of is letter \"m\".");
                Thread.sleep(3000);
                System.out.println("\nThank you for playing the game! I hope you did enjoy that.");
                Thread.sleep(2000);
                askUserToRestartCalculator();
            } else {
                notFamiliarWithFuturama(); }
        } else {
            notFamiliarWithFuturama();
        }
        guessAnswer.close();
    }

    private void notFamiliarWithFuturama() throws InterruptedException {
        Scanner askToRestart = new Scanner(System.in);

        System.out.println("\nSo I guess you are not familiar with Futurama.");
        System.out.print("Do you want me to show what this game is about (Y/N): ");
        if (askToRestart.hasNext("Y") || askToRestart.hasNext("y")) {
            openImageFromMiniGameFuturama();
            askUserToRestartCalculator();
        } else {
            askUserToRestartCalculator();
        }
        askToRestart.close();
    }

    private void openImageFromMiniGameFuturama() {
        try {
            Desktop.getDesktop().open(new File("image.jpg"));
        } catch (Exception ex) {
            System.out.println("\nI'm sorry, something went terribly wrong with loading image.");
        }
    }
}
