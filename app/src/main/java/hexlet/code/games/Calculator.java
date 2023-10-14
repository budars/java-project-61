package hexlet.code.games;
import hexlet.code.Engine;
import java.util.Random;

public class Calculator {
    private static final Random RANDOM = new Random();
    private static final String[] QUESTION_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String[] RIGHT_ANSWER_ARRAY = new String[Engine.STEPS_IN_GAME];
    private static final String GAME_QUESTION = "What is the result of the expression?";
    private static final String[] ARRAY_OF_OPERATORS = {"+", "-", "*"};
    private static final int BOUND_OF_NUMBERS = 20;
    private static final int LENGTH_OF_OPERATORS_ARRAY = 3;


    public static void calc() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int firstNumber = RANDOM.nextInt(BOUND_OF_NUMBERS);
            int secondNumber = RANDOM.nextInt(BOUND_OF_NUMBERS);
            String question = firstNumber + " " + ARRAY_OF_OPERATORS[RANDOM.nextInt(LENGTH_OF_OPERATORS_ARRAY)]
                    + " " + secondNumber;
            String rightAnswer = getRightAnswer(firstNumber, secondNumber, question);
            QUESTION_ARRAY[i] = question;
            RIGHT_ANSWER_ARRAY[i] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, QUESTION_ARRAY, RIGHT_ANSWER_ARRAY);
    }

    public static String getRightAnswer(int firstNumber, int secondNumber, String question) {
        if (question.contains("*")) {
            return String.valueOf(firstNumber * secondNumber);
        } else if (question.contains("+")) {
            return String.valueOf(firstNumber + secondNumber);
        }
        return String.valueOf(firstNumber - secondNumber);
    }
}
