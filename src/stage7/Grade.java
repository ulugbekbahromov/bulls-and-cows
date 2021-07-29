package stage7;

class Grade {
    private int bulls;
    private int cows;

    public Grade() {
        bulls = 0;
        cows = 0;
    }

    public int getBulls() {
        return bulls;
    }

    public void update(Secret secret, String guess) {
        bulls = 0;
        cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (secret.getSecret().charAt(i) == guess.charAt(i)) {
                bulls++;
            } else if (secret.getSecret().contains(Character.toString(guess.charAt(i)))){
                cows++;
            }
        }
    }

    private String valueToString(int value, String singular) {
        return String.format("%s %s",
                value != 0 ? value : "",
                value > 1 ? singular + "s" : value == 1 ? singular : "");
    }

    public String toString() {
        String output = String.format("%s %s %s",
                valueToString(this.bulls, "bull"),
                this.bulls == 0 || this.cows == 0 ? "" : "and",
                valueToString(this.cows, "cow"))
                .trim();

        return output.isEmpty() ? "None." : output;
    }
}