package hexlet.code;
import java.util.Scanner;

public class Cli {

    public static void answerName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        var name = sc.next();
        System.out.println("Hello, " + name + "!");
    }
}
