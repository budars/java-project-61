package hexlet.code;
import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int STEPS_IN_GAME = 3;

    public static void doEngine(String gameQuestion, String[] question, String[] rightAnswer) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = SCANNER.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(gameQuestion);

        int count = 0;
        while (count < STEPS_IN_GAME) {
            System.out.println("Question: " + question[count]);
            System.out.print("Your answer: ");
            String answer = SCANNER.nextLine();

            if (answer.equals(rightAnswer[count])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + rightAnswer[count] + "'");
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
