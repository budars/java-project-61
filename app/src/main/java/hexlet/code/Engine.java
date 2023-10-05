package hexlet.code;
import java.util.Scanner;

public class Engine {

    private static String name;
    public static final int STEPS_IN_GAME = 3;
    public static void greet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static String getName() {
        return name;
    }

    public static void printQuestionAndAnswer(int number1, int number2) {
        System.out.println("Question: " + number1 + " " + number2);
        System.out.print("Your answer: ");
    }

    public static void printQuestion(int questionVar) {
        System.out.println("Question: " + questionVar);
    }

    public static void printQuestion(String questionVar) {
        System.out.println("Question: " + questionVar);
    }

    public static void printAnswer() {
        System.out.print("Your answer: ");
    }

    public static void printWrong(int number, int answer) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + number + "'");
        System.out.println("Let's try again, " + getName() + "!");
    }

    public static void printWrong(String answer, String rightAnswer) {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
        System.out.println("Let's try again, " + getName() + "!");
    }

    public static void printCongratulations() {
        System.out.println("Congratulations, " + getName());
    }
}
