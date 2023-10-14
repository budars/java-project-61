package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;
public class Prime {
    private static final Random RANDOM = new Random();
    private static final String[] QUESTION_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String[] RIGHT_ANSWER_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int BOUND_OF_GIVEN_NUMBER = 174;

    public static void primeGame() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int givenNumber = RANDOM.nextInt(BOUND_OF_GIVEN_NUMBER);
            String question = String.valueOf(givenNumber);
            QUESTION_ARRAY[i] = question;
            String rightAnswer = isPrime(givenNumber) ? "yes" : "no";
            RIGHT_ANSWER_ARRAY[i] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, QUESTION_ARRAY, RIGHT_ANSWER_ARRAY);
    }

    public static boolean isPrime(int number) {
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
