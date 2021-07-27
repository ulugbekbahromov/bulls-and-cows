package stage4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");

        int n;
        while (true) {

            n = sc.nextInt();

            if (n <= 10) {
                break;
            } else {
                System.out.println("Error: can't generate a secret number with a length of" + n
                        + " because there aren't enough unique digits.");
                System.out.println("Please enter the length again:");
            }
        }

        sc.nextLine();

        String secretCode = randomGenerator(n);

        System.out.println("Okay, let's start a game!");

        int turn = 1;

        while (true) {

            int bulls = 0;
            int cows = 0;

            System.out.println("Turn " + turn++ + ":");

            String userCode = sc.nextLine();

            if (userCode.equals(secretCode)) {
                System.out.println("Grade: " + n + " bulls");
                break;
            }

            for (int i = 0; i < secretCode.length(); i++) {

                if (secretCode.charAt(i) == userCode.charAt(i)) {
                    bulls++;
                } else if (secretCode.contains(String.valueOf(userCode.charAt(i)))) {
                    cows++;
                }
            }

            String bullsStr = bulls > 1 ? "bulls" : "bull";
            String cowsStr = cows > 1 ? "cows" : "cow";

            if (bulls == 0 && cows == 0) {
                System.out.println("Grade: None.");
            } else if (bulls > 0 && cows == 0) {
                System.out.println("Grade: " + bulls + " " + bullsStr);
            } else if (cows > 0 && bulls == 0) {
                System.out.println("Grade: " + cows + " " + cowsStr);
            } else if (cows > 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " " + bullsStr + " and " + cows + " " + cowsStr);
            }
        }
        System.out.println("Congratulations! You guessed the secret code.");
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