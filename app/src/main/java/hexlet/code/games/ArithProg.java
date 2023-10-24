package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class ArithProg {
    private static final String GAME_QUESTION = "What number is missing in the progression?";
    private static final int STEP_BOUND = 7;
    private static final int BOUND_OF_FIRST_ELEMENT = 10;
    private static final int ORIGIN_OF_LENGTH_NUMBERS_ARRAY = 5;
    private static final int BOUND_OF_LENGTH_NUMBERS_ARRAY = 11;
    private static String[][] questionsAndAnswers = new String[Engine.STEPS_IN_GAME][Engine.QUESTION_AND_ANSWER];
    public static void arithmeticGame() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int step = Utils.getRandomInt(STEP_BOUND);
            int firstElement = Utils.getRandomInt(BOUND_OF_FIRST_ELEMENT);
            int arrayLength = Utils.getRandomInt(ORIGIN_OF_LENGTH_NUMBERS_ARRAY, BOUND_OF_LENGTH_NUMBERS_ARRAY);
            var givenArray = makeArithProgression(step, firstElement, arrayLength);
            var replacedIndex = Utils.getRandomInt(givenArray.length);
            String rightAnswer = String.valueOf(givenArray[replacedIndex]);
            questionsAndAnswers[i][Engine.ANSWER_INDEX] = rightAnswer;
            var censoredStrArray = returnFinalString(replacedIndex, givenArray);
            questionsAndAnswers[i][Engine.QUESTION_INDEX] = censoredStrArray;
        }

        Engine.doEngine(GAME_QUESTION, questionsAndAnswers);
    }

    public static String[] makeArithProgression(int step, int firstElement, int arrayLength) {
        int[] arrayOfNumbers = new int[arrayLength];
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
