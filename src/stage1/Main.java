package stage1;

public class Main {

    public static void main(String[] args) {
        printFirstLine();

        printTurn(1, "1234");
        printGrade(1, 1);

        printTurn(2, "1288");
        printGrade(1, 3);

        printLastLine("1289");
    }

    public static void printFirstLine() {
        System.out.println("The secret code is prepared: ****.\n");
    }

    public static void printTurn(int turn, String answer) {
        System.out.println("Turn " + turn + ". Answer:");
        System.out.println(answer);
    }

    public static void printGrade(int bulls, int cows) {
        String cowStr = "cow";
        String bullStr = "bull";
        String plural = "s";
        StringBuilder stringBuilder = new StringBuilder();

        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (bulls == 0 && cows > 0) {
            stringBuilder.append("Grade: ");
            printStringAnswer(cows, cowStr);
            if (cows > 1) {
                stringBuilder.append(plural);
            }
        } else if (cows == 0 && bulls > 0) {
            stringBuilder.append("Grade: ");
            printStringAnswer(bulls, bullStr);
            if (bulls > 1) {
                stringBuilder.append(plural);
            }
        } else if (cows > 0 && bulls > 0) {
            stringBuilder.append("Grade: ");
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
        System.out.println(stringBuilder.toString());
    }

    public static StringBuilder printStringAnswer(int type, String typeStr) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(type);
        stringBuilder.append(" ");
        stringBuilder.append(typeStr);

        return stringBuilder;
    }

    public static void printLastLine(String code) {
        System.out.println("Congrats! The secret code is " + code + ".");
    }
}