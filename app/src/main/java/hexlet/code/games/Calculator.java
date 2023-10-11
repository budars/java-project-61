package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calculator {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void calc() {
        Engine.greet();
        System.out.println("What is the result of the expression?");
        String[] arrayOfOperators = {"+", "-", "*"};
        final int BOUND_OF_NUMBERS = 20;
        final int LENGTH_OF_OPERATORS_ARRAY = 3;
        var count = 0;

        while (count < Engine.STEPS_IN_GAME) {
            int firstNumber = random.nextInt(BOUND_OF_NUMBERS);
            int secondNumber = random.nextInt(BOUND_OF_NUMBERS);
            String question = firstNumber + " " + arrayOfOperators[random.nextInt(LENGTH_OF_OPERATORS_ARRAY)]
                    + " " + secondNumber;
            Engine.printQuestionAndAnswer(question);
            var answer = scanner.nextInt();

            if (question.contains("*") && checkMultiplicationRightAnswer(firstNumber, secondNumber, answer)
                    || (question.contains("+") && checkSumRightAnswer(firstNumber, secondNumber, answer))
                    || (question.contains("-") && checkSubtractionRightAnswer(firstNumber, secondNumber, answer))) {
                System.out.println("Correct!");
            } else {
                Engine.printWrong(getRightAnswer(firstNumber, secondNumber, question), answer);
                break;
            }

            count++;
        }

        Engine.printCongratulations(count);
    }

    public static boolean checkMultiplicationRightAnswer(int firstNumber, int secondNumber, int answer) {
        return firstNumber * secondNumber == answer;
    }

    public static boolean checkSumRightAnswer(int firstNumber, int secondNumber, int answer) {
        return firstNumber + secondNumber == answer;
    }

    public static boolean checkSubtractionRightAnswer(int firstNumber, int secondNumber, int answer) {
        return firstNumber - secondNumber == answer;
    }

    public static int getRightAnswer(int firstNumber, int secondNumber, String question) {
        if (question.contains("*")) {
            return firstNumber * secondNumber;
        } else if (question.contains("+")) {
            return firstNumber + secondNumber;
        }
        return firstNumber - secondNumber;
    }
}
