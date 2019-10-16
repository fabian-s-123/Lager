package at.fabiansinz;

import java.rmi.server.ExportException;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        try {
            game.playGame();
        } catch (Exception e) {
        }

    }
}
