package hexlet.code;
import hexlet.code.games.ArithProg;
import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please enter the game number and press Enter
                1 - Greet
                2 - Even
                3 - Calculator
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");

        System.out.print("Your choice: ");
        var userChoice = scanner.nextLine();

        switch (userChoice) {
            case "1" -> Cli.answerName();
            case "2" -> Even.checkEven();
            case "3" -> Calculator.calc();
            case "4" -> GCD.playGcd();
            case "5" -> ArithProg.arithmeticGame();
            case "6" -> Prime.primeGame();
            default -> {
            }
        }
    }
}
