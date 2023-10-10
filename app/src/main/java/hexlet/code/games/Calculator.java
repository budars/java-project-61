package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;
import java.util.Scanner;

public class Calculator {

    public static void calc() {
        Engine.greet();
        System.out.println("What is the result of the expression?");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] arrayOfOperators = {"+", "-", "*"};
        var count = 0;

        while (count < Engine.STEPS_IN_GAME) {
            int firstNumber = random.nextInt(20);
            int secondNumber = random.nextInt(20);
            String question = firstNumber + " " + arrayOfOperators[random.nextInt(3)] + " " + secondNumber;
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
