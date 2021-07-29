package stage7;

enum Message{
    ENTER_LENGTH("Please, enter the secret code's length:"),
    ENTER_RANGE("Input the number of possible symbols in the code:"),
    SECRET_PREPARED("The secret is prepared: %s %s."),
    START_GAME("Okay, let's start a game!"),
    TURN("Turn %s:"),
    GRADE("Grade: %s"),
    WINNER("Congratulations! You guessed the secret code."),
    INVALID_NUMBER_ERROR("Error: \"%s\" isn't a valid number."),
    MAX_LENGTH_ERROR("Error: can't generate a secret number with a length of %s because there aren't enough unique digits."),
    MAX_RANGE_ERROR("Error: maximum number of possible symbols in the code is %s."),
    RANGE_ERROR("Error: it's not possible to generate a code with a length of %s " +
            "with %s unique symbols."),
    GUESS_LENGTH_ERROR("Error: \"%s\" doesn't have the required length of %s symbols."),
    GUESS_SYMBOL_ERROR("Error: \"%s\" contains invalid symbols, valid symbols are %s.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String arg) {
        return String.format(getMessage(), arg);
    }

    public String getMessage(String arg1, String arg2) {
        return String.format(getMessage(), arg1, arg2);
    }
}