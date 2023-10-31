package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static final int STEPS_IN_GAME = 3;
    public static final int QUESTION_AND_ANSWER = 2;
    public static final int QUESTION_INDEX = 0;
    public static final int ANSWER_INDEX = 1;

    public static void doEngine(String gameQuestion, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(gameQuestion);

        int count = 0;
        while (count < STEPS_IN_GAME) {
            System.out.println("Question: " + questionsAndAnswers[count][0]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (answer.equals(questionsAndAnswers[count][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[count][1] + "'");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
            count++;
        }

        if (count == STEPS_IN_GAME) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
