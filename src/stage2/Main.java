package stage2;

import java.util.Scanner;

public class Main {

    private static final String secretNumber = "9305";
    private static StringBuilder stringBuilder;
    private static int bulls = 0;
    private static int cows = 0;

    public static void main(String[] args) {

        printFirstLine();

        takeInput();

        printGrade();

        printLastLine();

    }

    public static void printFirstLine() {
        System.out.println("The secret code is prepared: ****.");
    }

    public static void takeInput() {
        Scanner scanner = new Scanner(System.in);

        char[] secretChar = secretNumber.toCharArray();
        String inputNumber = scanner.next();
        char[] numChar = inputNumber.toCharArray();


        for (int i = 0; i < numChar.length; i++) {
            if (secretChar[i] == numChar[i]) {
                bulls++;
            } else {
                for (char c : secretChar) {
                    if (c == numChar[i]) {
                        cows++;
                    }
                }
            }
        }
    }

    public static void printGrade() {
        String cowStr = "cow";
        String bullStr = "bull";
        String plural = "s";
        stringBuilder = new StringBuilder();

        if (bulls == 0 && cows == 0) {
            stringBuilder.append("None.");
        } else if (bulls == 0 && cows > 0) {
            printStringAnswer(cows, cowStr);
            if (cows > 1) {
                stringBuilder.append(plural);
            }
        } else if (cows == 0 && bulls > 0) {
            printStringAnswer(bulls, bullStr);
            if (bulls > 1) {
                stringBuilder.append(plural);
            }
        } else if (cows > 0 && bulls > 0) {
            printStringAnswer(bulls, bullStr);
            if (bulls > 1) {
                stringBuilder.append(plural);
            }

            stringBuilder.append(" and ");
            printStringAnswer(cows, cowStr);
            if (cows > 1) {
                stringBuilder.append(plural);
            }
        }
    }

    public static StringBuilder printStringAnswer(int type, String typeStr) {
        stringBuilder = new StringBuilder();

        stringBuilder.append(type);
        stringBuilder.append(" ");
        stringBuilder.append(typeStr);

        return stringBuilder;
    }

    public static void printLastLine() {
        System.out.println("Grade: " + stringBuilder.toString() + ".");
        System.out.println("The secret code is " + secretNumber + ".");
    }
}