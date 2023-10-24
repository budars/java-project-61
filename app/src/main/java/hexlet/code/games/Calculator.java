package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calculator {
    private static String[][] questionsAndAnswers = new String[Engine.STEPS_IN_GAME][Engine.QUESTION_AND_ANSWER];
    private static final String GAME_QUESTION = "What is the result of the expression?";
    private static final String[] ARRAY_OF_OPERATORS = {"+", "-", "*"};
    private static final int BOUND_OF_NUMBERS = 20;
    private static final int LENGTH_OF_OPERATORS_ARRAY = 3;


    public static void calc() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int firstNumber = Utils.getRandomInt(BOUND_OF_NUMBERS);
            int secondNumber = Utils.getRandomInt(BOUND_OF_NUMBERS);
            String question = firstNumber + " " + ARRAY_OF_OPERATORS[Utils.getRandomInt(LENGTH_OF_OPERATORS_ARRAY)]
                    + " " + secondNumber;
            String rightAnswer = String.valueOf(getRightAnswer(firstNumber, secondNumber, question));
            questionsAndAnswers[i][Engine.QUESTION_INDEX] = question;
            questionsAndAnswers[i][Engine.ANSWER_INDEX] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, questionsAndAnswers);
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
