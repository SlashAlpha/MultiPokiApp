package slash.code.table;

import org.springframework.stereotype.Component;
import slash.code.table.game.Game;

@Component
public class Table {

    Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
