package stage6;

enum Message{
    ENTER_LENGTH("Please, enter the secret code's length:"),
    ENTER_RANGE("Input the number of possible symbols in the code:"),
    SECRET_PREPARED("The secret is prepared: %s %s."),
    START_GAME("Okay, let's start a game!"),
    TURN("Turn %d:"),
    GRADE("Grade: %s"),
    WINNER("Congratulations! You guessed the secret code."),
    LENGTH_ERROR("Error: can't generate a secret number with a length of %d " +
            "because there aren't enough unique digits."),
    RANGE_ERROR("Error: can't generate a secret number with %d possible symbols " +
            "because there aren't enough unique digits for the specified length.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(int d) {
        return String.format(this.message, d);
    }
}