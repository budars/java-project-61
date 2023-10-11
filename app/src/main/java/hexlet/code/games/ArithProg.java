package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ArithProg {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    public static void arithmeticGame() {
        var count = 0;
        final int stepBound = 7;
        final int boundOfFirstElement = 10;
        Engine.greet();
        System.out.println("What number is missing in the progression?");

        while (count < Engine.STEPS_IN_GAME) {
            var step = random.nextInt(stepBound);
            var firstElement = random.nextInt(boundOfFirstElement);
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
        final int originOfLengthNumberArray = 5;
        final int boundOfLengthNumbersArray = 11;
        int[] arrayOfNumbers = new int[random.nextInt(originOfLengthNumberArray, boundOfLengthNumbersArray)];
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
