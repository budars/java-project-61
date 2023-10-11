package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;
import java.util.Random;

public class Even {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static void checkEven() {
        Engine.greet();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var count = 0;
        int maxNumberValue = 4096;

        while (count < Engine.STEPS_IN_GAME) {
            var number = random.nextInt(maxNumberValue);
            Engine.printQuestionAndAnswer(number);
            var answer = scanner.nextLine();
            //next variable check number is even or not
            boolean checker = number % 2 == 0;
            String rightAnswer = checker ? "yes" : "no";
            if ((checker && answer.equals("no")) || (!checker && answer.equals("yes"))) {
                Engine.printWrong(answer, rightAnswer);
                break;
            } else if ((checker && answer.equals("yes")) || (!checker && answer.equals("no"))) {
                System.out.println("Correct!");
            } else {
                Engine.printWrong(answer, rightAnswer);
                break;
            }
            count++;
        }

        //this conditional statement needs for printing final Congratulations, if loop was fully completed
        Engine.printCongratulations(count);
    }
}
