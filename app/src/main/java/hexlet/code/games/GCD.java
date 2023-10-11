package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;
import java.util.Random;

public class GCD {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void findGcd() {
        Engine.greet();
        System.out.println("Find the greatest common divisor of given numbers.");

        int maxValueExclusive = 100;
        int count = 0;

        while (count < Engine.STEPS_IN_GAME) {
            int firstNumber = random.nextInt(maxValueExclusive);
            int secondNumber = random.nextInt(maxValueExclusive);
            var max = Math.max(firstNumber, secondNumber);
            var min = Math.min(firstNumber, secondNumber);

            Engine.printQuestionAndAnswer(firstNumber, secondNumber);
            var answer = scanner.nextInt();

            if (answer == checkRightAnswer(max, min)) {
                System.out.println("Correct!");
            } else {
                Engine.printWrong(checkRightAnswer(max, min), answer);
                break;
            }
            count++;
        }

        Engine.printCongratulations(count);
    }

    public static int checkRightAnswer(int max, int min) {
        if (max == 0 || min == 0) {
            return 0;
        }
        int remainder;
        int tmp;

        if (max % min != 0) {
            while (max % min != 0) {
                remainder = max % min;
                tmp = min;
                min = remainder;
                max = tmp;
            }

        }
        return min;
    }
}
