package stage5;

import java.util.Random;

public class Secret {
    private final int SIZE;
    private final String SECRET;

    public Secret(int size) {
        this.SIZE = size;
        this.SECRET = makeSecret();
    }

    private String makeSecret() {
        Random random = new Random();
        StringBuilder secret = new StringBuilder();

        do {
            int digit = random.nextInt(10);

            if (!(secret.toString().contains(Integer.toString(digit)))) {
                if (secret.length() == 0) {
                    if (digit != 0) {
                        secret.append(digit);
                    }
                } else {
                    secret.append(digit);
                }
            }
        } while (secret.length() < this.SIZE);

        return secret.toString();
    }

    public String getSecret() {
        return this.SECRET;
    }

    public int getSize() {
        return SIZE;
    }
}