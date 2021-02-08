package slash.code.table.services;

import org.springframework.jms.core.JmsTemplate;

import slash.code.table.config.JmsConfig;
import slash.code.table.game.*;

import org.springframework.stereotype.Service;
import slash.code.table.player.Player;


import java.util.*;
//dicton de maitre Dong: "il faut donner du jms pour recevoir du jms"

@Service
public class GameServices implements GameService {

    GameRepository gameRepository;
    private final JmsTemplate jmsTemplate;
    ArrayList<Player> players = new ArrayList<>();
    CardService cardService;
    PlayerService playerService;


    public GameServices(GameRepository gameRepository, JmsTemplate jmsTemplate, CardService cardService, PlayerService playerService) {
        this.gameRepository = gameRepository;
        this.jmsTemplate = jmsTemplate;
        this.cardService = cardService;
        this.playerService = playerService;
    }

    @Override
    public void launchGame() {
        int players1 = players.size();
        System.out.println("sending game id");


        System.out.println("sending message");

        if (players1 > 1) {
            System.out.println("welcome to the game");
            jmsTemplate.convertAndSend(JmsConfig.NEW_GAME_QUEUE, players1);


        }
    }


    @Override
    public ArrayList<Player> addPlayers(Player player) {
        this.players.add(player);
        return players;
    }

    @Override
    public void setBlinds(Game gameA) {

        Game game = gameA;
        players.get(0).betting(game.getSb());
        playerService.savePlayer(players.get(0));
        players.get(1).betting(game.getBb());
        playerService.savePlayer(players.get(1));

    }


    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
