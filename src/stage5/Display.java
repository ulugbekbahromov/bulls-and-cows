package stage5;

import java.util.Scanner;

public class Display {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }

    public static int getSize() throws IndexOutOfBoundsException, NumberFormatException {
        Display.print(Message.ENTER_LENGTH);
        int input = Integer.parseInt(getInput());

        if (input > 10) {
            throw new IndexOutOfBoundsException(Message.SIZE_ERROR.getMessage());
        }

        return input;
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
}