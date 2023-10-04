package hexlet.code;
import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void checkEven() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        /*greetings. I add again this code in this Class
        cause I don't know how i can get name from user for phrase "Congratulations, Sam!"*/
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        var name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var count = 0; //Step counter for loop

        while (count < 3) {
            var number = random.nextInt(4096);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            var answer = scanner.nextLine();
            //next variable check number is even or not
            boolean checker = number % 2 == 0;
            //next condition statement recognize
            if ((checker && answer.equals("no")) || (!checker && answer.equals("yes"))) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + returnYesOrNo(number) + "'");
                break;
            } else if ((checker && answer.equals("yes")) || (!checker && answer.equals("no"))) {
                System.out.println("Correct");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was'"
                        + returnYesOrNo(number) + "'");
                break;
            }
            count++;
        }

        //this conditional statement needs for printing final Congratulations, if loop was fully completed
        if (count == 3) {
            System.out.println("Congratulations, " + name);
        }
    }

    //this method i use for wrong answer to don't write if-else code again
    public static String returnYesOrNo(int number) {
        if (number % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}
