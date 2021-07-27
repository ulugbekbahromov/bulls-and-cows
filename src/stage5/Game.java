package stage5;

public class Game {
    private final Secret SECRET;
    private final Grade GRADE;
    private int turn;

    public Game(Secret secret) {
        this.SECRET = secret;
        this.GRADE = new Grade();
        this.turn = 1;
    }

    public void guess(String guess) {
        this.GRADE.update(this.SECRET, guess);
    }

    public String getGrade() {
        return this.GRADE.toString();
    }

    public int getTurn() {
        return this.turn;
    }

    public void nextTurn() {
        this.turn++;
    }

    public boolean isWinner() {
        return GRADE.getBulls() == SECRET.getSize();
    }
}