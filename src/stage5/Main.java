package stage5;

public class Main {
    public static void main(String[] args) {
        Game game = null;
        boolean error;

        do {
            try {
                error = false;
                game = new Game(new Secret(Display.getSize()));
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                Display.print(e.getMessage());
                error = true;
            }
        } while (error);

        Display.print(Message.START_GAME);

        do {
            game.guess(Display.getGuess(game.getTurn()));
            Display.print(Message.GRADE, game.getGrade());
            game.nextTurn();
        } while (!game.isWinner());

        Display.print(Message.WINNER);
    }
}