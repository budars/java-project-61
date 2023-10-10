package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;
import java.util.Random;

public class GCD {

    public static void findGcd() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Engine.greet();
        System.out.println("Find the greatest common divisor of given numbers");

        int count = 0;

        while (count < Engine.STEPS_IN_GAME) {
            int firstNumber = random.nextInt(100);
            int secondNumber = random.nextInt(100);
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

        if (count == 3) {
            Engine.printCongratulations();
        }
    }

    public static int checkRightAnswer(int max, int min) {
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
