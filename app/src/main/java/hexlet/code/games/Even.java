package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final String GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int BOUND_OF_NUMBER = 4096;
    private static String[][] questionsAndAnswers = new String[Engine.STEPS_IN_GAME][Engine.QUESTION_AND_ANSWER];
    public static void checkEven() {

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int number = Utils.getRandomInt(BOUND_OF_NUMBER);
            String question = String.valueOf(number);
            questionsAndAnswers[i][Engine.QUESTION_INDEX] = question;
            String rightAnswer = isEven(number) ? "yes" : "no";
            questionsAndAnswers[i][Engine.ANSWER_INDEX] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, questionsAndAnswers);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
