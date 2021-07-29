package stage7;

public class Main {
    public static void main(String[] args) {

        int length = DisplayIO.requestLength();

        if (length < 0) {
            return;
        }

        int range = DisplayIO.requestRange(length);

        if (range < 0) {
            return;
        }

        Game game = new Game(new Secret(length, range));
        DisplayIO.print(Message.SECRET_PREPARED, game.maskSecret(), Secret.getRange(range));
        DisplayIO.print(Message.START_GAME);

        do {
            String guess = DisplayIO.requestGuess(game.getTurn(), length, range);

            if (guess != null) {
                game.guess(guess);
                DisplayIO.print(Message.GRADE, game.getGrade());
                game.nextTurn();
            }
        } while (!game.isWinner());

        DisplayIO.print(Message.WINNER);
    }
}