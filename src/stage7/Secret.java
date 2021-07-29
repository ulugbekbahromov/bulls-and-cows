package stage7;

import java.util.ArrayList;
import java.util.Random;

class Secret {
    public static final int MAX_LENGTH = 36;
    private final int LENGTH;
    private final int RANGE;
    private final String SECRET;

    public Secret(int size, int range) {
        this.LENGTH = size;
        this.RANGE = range;
        SECRET = makeSecret();
    }

    private String makeSecret() {
        Random random = new Random();
        StringBuilder secret = new StringBuilder();

        do {
            String symbol = getSymbol(random.nextInt(RANGE));

            if (!(secret.toString().contains(symbol))) {
                secret.append(symbol);
            }
        } while (secret.length() < LENGTH);

        return secret.toString();
    }

    public String maskSecret() {
        return "*".repeat(Math.max(0, LENGTH));
    }

    public String getSecret() {
        return SECRET;
    }

    public int getLength() {
        return LENGTH;
    }

    public static String getRange(int range) {
        String format = range <= 10 ? "(0 - %s)" : "(0 - 9, a - %s)";

        return String.format(format, getSymbol(range - 1));
    }

    public static ArrayList<String> getRangeSymbols(int range) {
        ArrayList<String> symbols = new ArrayList<>();

        for (int i = 0; i < range; i++) {
            symbols.add(getSymbol(i));
        }

        return symbols;
    }

    private static String getSymbol(int digit) {
        int asciiStart = 97;
        int offset = 10;

        return digit <= 9 ? Integer.toString(digit)
                : Character.toString((char) (asciiStart - offset + digit));
    }
}