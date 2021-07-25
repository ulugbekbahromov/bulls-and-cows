package stage3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        if (length > 9) {
            System.out.println("Error: can't generate " +
                    "a secret number with a length of 11 " +
                    "because there aren't enough unique digits.");
            return;
        }

        System.out.println(randomGenerator(length));
    }

    public static String randomGenerator(int length) {

        List<Integer> randomList = new ArrayList<>(List.of(0, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(randomList);
        StringBuilder result = new StringBuilder();

        for (var ch : randomList.subList(0, length)) {
            result.append(ch);
        }
        return result.toString();
    }
}