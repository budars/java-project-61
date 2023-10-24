package hexlet.code;
import java.util.Random;

public class Utils {
    private static Random random = new Random();
    public static int getRandomInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public static int getRandomInt(int bound) {
        return random.nextInt(bound);
    }
}
