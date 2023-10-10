package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ArithProg {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    public static void arithmeticGame() {
        var count = 0;
        Engine.greet();
        System.out.println("What number is missing in the progression?");

        while (count < Engine.STEPS_IN_GAME) {
            var step = random.nextInt(7);
            var firstElement = random.nextInt(10);
            var givenArray = makeArithProgression(step, firstElement);
            var replacedIndex = random.nextInt(givenArray.length);
            var censoredStrArray = returnFinalString(replacedIndex, givenArray);
            Engine.printQuestionAndAnswer(censoredStrArray);
            var answer = scanner.nextLine();

            if (answer.equals(givenArray[replacedIndex])) {
                System.out.println("Correct!");
            } else {
                Engine.printWrong(answer, givenArray[replacedIndex]);
                break;
            }

            count++;
        }

        Engine.printCongratulations(count);
    }

    public static String[] makeArithProgression(int step, int firstElement) {
        int[] arrayOfNumbers = new int[random.nextInt(5, 11)];
        arrayOfNumbers[0] = firstElement;
        var strArray = new String[arrayOfNumbers.length];
        strArray[0] = String.valueOf(firstElement);
        for (var i = 1; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = arrayOfNumbers[i - 1] + step;
            strArray[i] = String.valueOf(arrayOfNumbers[i]);
        }
        return strArray;
    }

    public static String returnFinalString(int replacedIndex, String[] strArray) {
        var copiedArray = Arrays.copyOf(strArray, strArray.length);
        copiedArray[replacedIndex] = "..";
        StringBuilder builder = new StringBuilder();
        for (String value : copiedArray) {
            builder.append(value);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
