package stage6;

import java.util.Scanner;

public class Display {

    private static final Scanner scanner = new Scanner(System.in);

    private static String getInput() {
        return scanner.nextLine();
    }

    public static int requestLength() throws IndexOutOfBoundsException, NumberFormatException {

        Display.print(Message.ENTER_LENGTH);
        int input = Integer.parseInt(getInput());

        isValidLength(input);

        return input;
    }

    public static int requestRange(int length) throws IndexOutOfBoundsException, NumberFormatException {

        Display.print(Message.ENTER_RANGE);
        int input = Integer.parseInt(getInput());

        isValidLength(input);

        if (input < length) {
            throw new IndexOutOfBoundsException(Message.RANGE_ERROR.getMessage(input));
        }

        return input;
    }

    private static void isValidLength(int input) throws IndexOutOfBoundsException{
        if (input > Secret.MAX_LENGTH) {
            throw new IndexOutOfBoundsException(Message.LENGTH_ERROR.getMessage(input));
        }
    }

    public static String getGuess(int turn) {
        Display.print(Message.TURN, turn);
        return Display.getInput();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Message message) {
        print(message.getMessage());
    }

    public static void print(Message message, int num) {
        System.out.printf(message.getMessage() + "%n", num);
    }

    public static void print(Message message, String str) {
        System.out.printf(message.getMessage() + "%n", str);
    }

    public static void print(Message message, String str1, String str2) {
        System.out.printf(message.getMessage() + "%n", str1, str2);
    }
}