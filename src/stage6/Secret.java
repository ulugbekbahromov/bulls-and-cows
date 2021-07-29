package stage6;

import java.util.Random;

public class Secret {
    public static final int MAX_LENGTH = 36;
    private final int LENGTH;
    private final int RANGE;
    private final String SECRET;

    public Secret(int size, int range) {
        this.LENGTH = size;
        this.RANGE = range;
        this.SECRET = makeSecret();
    }

    private String makeSecret() {
        Random random = new Random();
        StringBuilder secret = new StringBuilder();

        do {
            String symbol = getSymbol(random.nextInt(this.RANGE));

            if (!(secret.toString().contains(symbol))) {
                secret.append(symbol);
            }
        } while (secret.length() < this.LENGTH);

        return secret.toString();
    }

    public String maskSecret() {
        return "*".repeat(Math.max(0, this.LENGTH));
    }

    public String getRange() {
        String format = this.RANGE <= 10 ? "(0 - %s)" : "(0 - 9, a - %s)";

        return String.format(format, getSymbol(this.RANGE - 1));
    }

    private String getSymbol(int digit) {
        int asciiStart = 97;
        int offset = 10;

        return digit <= 9 ? Integer.toString(digit)
                : Character.toString((char) (asciiStart - offset + digit));
    }

    public String getSecret() {
        return this.SECRET;
    }

    public int getLength() {
        return LENGTH;
    }
}