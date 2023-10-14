package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static final Random RANDOM = new Random();
    private static final String GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[] QUESTION_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String[] RIGHT_ANSWER_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final int BOUND_OF_NUMBER = 4096;
    public static void checkEven() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int number = RANDOM.nextInt(BOUND_OF_NUMBER);
            String question = String.valueOf(number);
            QUESTION_ARRAY[i] = question;
            String rightAnswer = isEven(number) ? "yes" : "no";
            RIGHT_ANSWER_ARRAY[i] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, QUESTION_ARRAY, RIGHT_ANSWER_ARRAY);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
