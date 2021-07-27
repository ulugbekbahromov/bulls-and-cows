package stage5;

enum Message{
    ENTER_LENGTH("Please, enter the secret code's length:"),
    START_GAME("Okay, let's start a game!"),
    TURN("Turn %d:"),
    GRADE("Grade: %s"),
    WINNER("Congratulations! You guessed the secret code."),
    SIZE_ERROR("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}