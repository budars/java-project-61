package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final Random RANDOM = new Random();
    private static final String[] QUESTION_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String[] RIGHT_ANSWER_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String GAME_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final int BOUND_OF_NUMBER = 100;

    public static void playGcd() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int firstNumber = RANDOM.nextInt(BOUND_OF_NUMBER);
            int secondNumber = RANDOM.nextInt(BOUND_OF_NUMBER);
            String question = String.valueOf(firstNumber) + " " + String.valueOf(secondNumber);
            QUESTION_ARRAY[i] = question;
            var max = Math.max(firstNumber, secondNumber);
            var min = Math.min(firstNumber, secondNumber);
            String rightAnswer = String.valueOf(checkRightAnswer(max, min));
            RIGHT_ANSWER_ARRAY[i] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, QUESTION_ARRAY, RIGHT_ANSWER_ARRAY);
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
