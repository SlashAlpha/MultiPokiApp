package slash.code.table.services;

import slash.code.table.river.Card;
import slash.code.table.player.Player;

public interface PlayerService {

    void getPlayerCards(Player player);

    Player savePlayer(Player player);
}




