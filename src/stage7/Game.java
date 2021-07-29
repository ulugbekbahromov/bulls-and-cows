package stage7;

class Game {
    private final Secret SECRET;
    private final Grade GRADE;
    private int turn;

    public Game(Secret secret) {
        this.SECRET = secret;
        GRADE = new Grade();
        turn = 1;
    }

    public String maskSecret() {
        return SECRET.maskSecret();
    }

    public void guess(String guess) {
        GRADE.update(SECRET, guess);
    }

    public String getGrade() {
        return GRADE.toString();
    }

    public int getTurn() {
        return turn;
    }

    public void nextTurn() {
        turn++;
    }

    public boolean isWinner() {
        return GRADE.getBulls() == SECRET.getLength();
    }
}