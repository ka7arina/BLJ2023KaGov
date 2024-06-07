package ch.noseryoung;

public class Starter {
    public static void main(String[] args) {
        Game game = new Game();
        new GameIO(game, 64, 1);
    }
}
