package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String GAME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int BOUND_OF_GIVEN_NUMBER = 174;

    public static void primeGame() {
        String[][] questionsAndAnswers = new String[Engine.STEPS_IN_GAME][Engine.QUESTION_AND_ANSWER];

        for (var i = 0; i < Engine.STEPS_IN_GAME; i++) {
            int givenNumber = Utils.getRandomInt(BOUND_OF_GIVEN_NUMBER);
            String question = String.valueOf(givenNumber);
            questionsAndAnswers[i][Engine.QUESTION_INDEX] = question;
            String rightAnswer = isPrime(givenNumber) ? "yes" : "no";
            questionsAndAnswers[i][Engine.ANSWER_INDEX] = rightAnswer;
        }

        Engine.doEngine(GAME_QUESTION, questionsAndAnswers);
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
