package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void checkEven() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        /*greetings. I add again this code in this Class
        cause I don't know how i can get name from user for phrase "Congratulations, Sam!"*/
        Engine.greet();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var count = 0; //Step counter for loop

        while (count < Engine.STEPS_IN_GAME) {
            var number = random.nextInt(4096);
            Engine.printQuestion(number);
            Engine.printAnswer();
            var answer = scanner.nextLine();
            //next variable check number is even or not
            boolean checker = number % 2 == 0;
            if ((checker && answer.equals("no")) || (!checker && answer.equals("yes"))) {
                Engine.printWrong(answer, returnYesOrNo(number));
                break;
            } else if ((checker && answer.equals("yes")) || (!checker && answer.equals("no"))) {
                System.out.println("Correct!");;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was'"
                        + returnYesOrNo(number) + "'");
                break;
            }
            count++;
        }

        //this conditional statement needs for printing final Congratulations, if loop was fully completed
        if (count == 3) {
            Engine.printCongratulations();
        }
    }

    //this method i use for wrong answer to don't write if-else code again
    private static String returnYesOrNo(int number) {
        if (number % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}
