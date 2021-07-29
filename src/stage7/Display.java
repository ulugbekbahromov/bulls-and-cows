package stage7;

import java.util.ArrayList;
import java.util.Scanner;

class DisplayIO {
    private static final Scanner scanner = new Scanner(System.in);

    private static String getInput() {
        return scanner.nextLine();
    }

    public static int requestLength() {
        print(Message.ENTER_LENGTH);
        String input = getInput();

        if (notValidInput(input)) {
            print(Message.INVALID_NUMBER_ERROR.getMessage(input));
            return -1;
        }

        int length = Integer.parseInt(input);

        if (notValidLength(length, 1, Secret.MAX_LENGTH)) {
            print(Message.MAX_LENGTH_ERROR.getMessage(input));
            return -1;
        }

        return length;
    }

    public static int requestRange(int length) {
        print(Message.ENTER_RANGE);
        String input = getInput();

        if (notValidInput(input)) {
            print(Message.INVALID_NUMBER_ERROR.getMessage(input));
            return -1;
        }

        int range = Integer.parseInt(input);

        if (range < length) {
            print(Message.RANGE_ERROR.getMessage(Integer.toString(length), input));
            return -1;
        }

        if(notValidLength(range, 1, Secret.MAX_LENGTH)) {
            print(Message.MAX_RANGE_ERROR.getMessage(input));
            return -1;
        }

        return range;
    }

    public static String requestGuess(int turn, int length, int range) {
        print(Message.TURN, Integer.toString(turn));
        String input = getInput();

        if (notValidLength(input.length(), length, length)) {
            print(Message.GUESS_LENGTH_ERROR.getMessage(input, Integer.toString(length)));
            return null;
        }

        if (notValidGuess(input, range)) {
            print(Message.GUESS_SYMBOL_ERROR.getMessage(input, Secret.getRange(range)));
            return null;
        }

        return input;
    }

    private static boolean notValidInput(String input) {
        return !input.matches("^\\d+$");
    }

    private static boolean notValidLength(int length, int min, int max) {
        return length < min || length > max;
    }

    private static boolean notValidGuess(String guess, int range) {
        ArrayList<String> symbols = Secret.getRangeSymbols(range);

        for (int i = 0; i < guess.length(); i++) {
            if (!symbols.contains(Character.toString(guess.charAt(i)))) {
                return true;
            }
        }

        return false;
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public static void print(Message message) {
        print(message.getMessage());
    }

    public static void print(Message message, String str) {
        System.out.printf(message.getMessage() + "%n", str);
    }

    public static void print(Message message, String str1, String str2) {
        System.out.printf(message.getMessage() + "%n", str1, str2);
    }
}