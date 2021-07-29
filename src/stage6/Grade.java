package stage6;

public class Grade {

    private int bulls;
    private int cows;

    public Grade() {
        this.bulls = 0;
        this.cows = 0;
    }

    public int getBulls() {
        return this.bulls;
    }

    public void update(Secret secret, String guess) {
        this.bulls = 0;
        this.cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (secret.getSecret().charAt(i) == guess.charAt(i)) {
                this.bulls++;
            } else if (secret.getSecret().contains(Character.toString(guess.charAt(i)))){
                this.cows++;
            }
        }
    }

    public String toString() {
        String bullString = this.bulls > 1 ? "bulls" : this.bulls == 1 ? "bull" : "";
        String cowString = this.cows > 1 ? "cows" : this.bulls == 1 ? "cow" : "";

        return this.bulls == 0 && this.cows == 0 ? "None"
                : this.bulls > 0 && this.cows > 0 ? this.bulls + " " + bullString
                + " and " + this.cows + " " + cowString
                : this.bulls > 0 ? this.bulls + " " + bullString
                : this.cows > 0 ? this.cows + " " + cowString
                : "";
    }
}