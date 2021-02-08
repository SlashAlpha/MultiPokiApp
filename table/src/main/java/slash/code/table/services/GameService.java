package slash.code.table.services;

import slash.code.table.game.Game;
import slash.code.table.player.Player;

import java.util.ArrayList;
import java.util.UUID;

public interface GameService {

    public void launchGame();

    public Game saveGame(Game game);

    public ArrayList<Player> addPlayers(Player player);

    public void setBlinds(Game game);

    public ArrayList<Player> getPlayers();


}
