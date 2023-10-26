package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final String GAME_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final int BOUND_OF_NUMBER = 100;
    private static String[][] questionsAndAnswers = new String[Engine.STEPS_IN_GAME][Engine.QUESTION_AND_ANSWER];

    public static void playGcd() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int firstNumber = Utils.getRandomInt(BOUND_OF_NUMBER);
            int secondNumber = Utils.getRandomInt(BOUND_OF_NUMBER);
            String question = firstNumber + " " + secondNumber;
            questionsAndAnswers[i][Engine.QUESTION_INDEX] = question;
            var max = Math.max(firstNumber, secondNumber);
            var min = Math.min(firstNumber, secondNumber);
            String rightAnswer = String.valueOf(checkRightAnswer(max, min));
            questionsAndAnswers[i][Engine.ANSWER_INDEX] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, questionsAndAnswers);
    }

    public static int checkRightAnswer(int max, int min) {
        if (min == 0) {
            return max;
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
