package slash.code.table.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import slash.code.table.Table;
import slash.code.table.analysis.Analysis;
import slash.code.table.config.JmsConfig;
import slash.code.table.game.Game;
import slash.code.table.player.Player;
import slash.code.table.river.River;
import slash.code.table.services.BettingService;
import slash.code.table.services.GameService;
import slash.code.table.services.PlayerService;
import slash.code.table.services.RiverService;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    PlayerService playerService;
    RiverService riverService;
    GameService gameService;
    JmsTemplate jmsTemplate;
    Table table;
    BettingService bettingService;


    public DataLoader(PlayerService playerService, RiverService riverService, GameService gameService, JmsTemplate jmsTemplate, Table table, BettingService bettingService) {
        this.playerService = playerService;
        this.riverService = riverService;
        this.gameService = gameService;
        this.jmsTemplate = jmsTemplate;
        this.table = table;
        this.bettingService = bettingService;
    }

    @Override
    public void run(String... args) throws Exception {
        Analysis analysis = new Analysis();

        Player player = Player.builder().gameOrder(1).bank(1000).name("Bernard").gamePlayed(0).age(30).build();
        Player player2 = Player.builder().gameOrder(2).bank(1000).name("Ginette").gamePlayed(0).age(30).build();
        gameService.addPlayers(player);
        gameService.addPlayers(player2);


        Game game = Game.builder().player1(playerService.savePlayer(player)).player2(playerService.savePlayer(player2)).build();


        System.out.println("launching game");
        gameService.launchGame();


        playerService.getPlayerCards(player);
        playerService.getPlayerCards(player2);


        River river = River.builder().build();


        game.setSb(bettingService.getSmallBlind());
        game.setBb(bettingService.getBigBlind());

        gameService.saveGame(game);

        gameService.setBlinds(game);


        riverService.getFirstWave(river);

        riverService.getSecondWave(river);

        riverService.getThirdWave(river);

        System.out.println(river.getOne());
        System.out.println(river.getTwo());
        System.out.println(river.getThree());
        System.out.println(river.getFour());
        System.out.println(river.getFive());


    }
}
