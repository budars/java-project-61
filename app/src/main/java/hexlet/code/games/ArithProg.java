package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Arrays;

public class ArithProg {
    private static final Random RANDOM = new Random();
    private static final String GAME_QUESTION = "What number is missing in the progression?";
    private static final String[] QUESTION_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String[] RIGHT_ANSWER_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final int STEP_BOUND = 7;
    private static final int BOUND_OF_FIRST_ELEMENT = 10;
    private static final int ORIGIN_OF_LENGTH_NUMBERS_ARRAY = 5;
    private static final int BOUND_OF_LENGTH_NUMBERS_ARRAY = 11;
    public static void arithmeticGame() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int step = RANDOM.nextInt(STEP_BOUND);
            int firstElement = RANDOM.nextInt(BOUND_OF_FIRST_ELEMENT);
            var givenArray = makeArithProgression(step, firstElement);
            var replacedIndex = RANDOM.nextInt(givenArray.length);
            String rightAnswer = String.valueOf(givenArray[replacedIndex]);
            RIGHT_ANSWER_ARRAY[i] = rightAnswer;
            var censoredStrArray = returnFinalString(replacedIndex, givenArray);
            QUESTION_ARRAY[i] = censoredStrArray;
        }

        Engine.doEngine(GAME_QUESTION, QUESTION_ARRAY, RIGHT_ANSWER_ARRAY);
    }

    public static String[] makeArithProgression(int step, int firstElement) {
        int[] arrayOfNumbers = new int[RANDOM.nextInt(ORIGIN_OF_LENGTH_NUMBERS_ARRAY, BOUND_OF_LENGTH_NUMBERS_ARRAY)];
        arrayOfNumbers[0] = firstElement;
        var strArray = new String[arrayOfNumbers.length];
        strArray[0] = String.valueOf(firstElement);
        for (var i = 1; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = arrayOfNumbers[i - 1] + step;
            strArray[i] = String.valueOf(arrayOfNumbers[i]);
        }
        return strArray;
    }

    public static String returnFinalString(int replacedIndex, String[] strArray) {
        var copiedArray = Arrays.copyOf(strArray, strArray.length);
        copiedArray[replacedIndex] = "..";
        StringBuilder builder = new StringBuilder();
        for (String value : copiedArray) {
            builder.append(value);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
