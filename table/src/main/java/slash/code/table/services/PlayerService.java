package slash.code.table.services;

import slash.code.table.Card;
import slash.code.table.player.Player;

public interface PlayerService {
    Card getCard();
    void getPlayerCards(Player player);
}
