package slash.code.table.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import slash.code.table.river.Card;
import slash.code.table.player.Player;
import slash.code.table.player.PlayerRepository;

@ConfigurationProperties(prefix = "slash.code")
@Service
public class PlayersServices implements PlayerService {
    public final static String PLAYER_PATH_V1 = "/api/v1/dealer/player/card";

    private final RestTemplate restTemplate;

    private String dealerServiceHost;

    public PlayerRepository playerRepository;

    public CardService cardService;

    public PlayersServices(RestTemplateBuilder restTemplate, PlayerRepository playerRepository, CardService cardService) {
        this.restTemplate = restTemplate.build();
        this.playerRepository = playerRepository;
        this.cardService = cardService;

    }


    public void setDealerServiceHost(String dealerServiceHost) {
        this.dealerServiceHost = dealerServiceHost;
    }


    @Override
    public void getPlayerCards(Player player) {
        Card one = cardService.getOne();
        player.setOne(one);
        Card two = cardService.getOne();
        player.setTwo(two);
        System.out.println(one);
        System.out.println(two);
        savePlayer(player);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }


}
