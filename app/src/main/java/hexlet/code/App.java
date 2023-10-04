package hexlet.code;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please enter the game number and press Enter
                1 - Greet
                2 - Even
                0 - Exit""");

        System.out.print("Your choice: ");
        var userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                Cli.answerName();
                break;
            case 2:
                Even.checkEven();
            case 0:
            default:
                break;



        }
    }
}
