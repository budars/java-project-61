package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;
import java.util.Random;
public class Prime {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void isPrime() {
        var count = 0;
        Engine.greet();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        final int boundOfGiverNumber = 174;

        while (count < Engine.STEPS_IN_GAME) {
            int givenNumber = random.nextInt(boundOfGiverNumber);
            Engine.printQuestionAndAnswer(givenNumber);
            String answer = scanner.nextLine();
            boolean checkedPrime = checkPrime(givenNumber);
            String rightAnswer = checkedPrime ? "yes" : "no";

            if ((answer.equalsIgnoreCase("yes") && checkedPrime)
                    || (answer.equalsIgnoreCase("no")) && !checkedPrime) {
                System.out.println("Correct!");
            } else {
                Engine.printWrong(answer, rightAnswer);
                break;
            }
            count++;
        }

        Engine.printCongratulations(count);
    }

    public static boolean checkPrime(int number) {
        if (number == 1) {
            return true;
        }
        var j = 0;
        for (var i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                j = 1;
                break;
            }
        }

        return !(j == 1);
    }
}
