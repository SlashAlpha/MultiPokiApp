package slash.code.table.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import slash.code.table.Card;
import slash.code.table.player.Player;
import slash.code.table.river.River;
import slash.code.table.services.PlayerService;
import slash.code.table.services.RiverService;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    PlayerService playerService;
    RiverService riverService;

    public DataLoader(PlayerService playerService, RiverService riverService) {
        this.playerService = playerService;
        this.riverService = riverService;
    }

    @Override
    public void run(String... args) throws Exception {
       Player player=Player.builder().id(UUID.randomUUID()).name("Bernard").gamePlayed(0).age(30).playerCards(new ArrayList<Card>()).build();
      playerService.getPlayerCards(player);


        River river=River.builder().riverCards(new ArrayList<Card>()).build();
        riverService.getFirstWave(river);

        riverService.getSecondWave(river);

        riverService.getThirdWave(river);

    }
}
