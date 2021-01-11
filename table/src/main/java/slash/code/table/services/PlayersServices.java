package slash.code.table.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import slash.code.table.Card;
import slash.code.table.player.Player;

@ConfigurationProperties(prefix = "slash.code")
@Service
public class PlayersServices implements PlayerService{
    public final static String PLAYER_PATH_V1 = "/api/v1/dealer/player/card";

    private final RestTemplate restTemplate;

    private String dealerServiceHost;

    public PlayersServices(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public Card getCard() {
        return restTemplate.getForObject(dealerServiceHost+PLAYER_PATH_V1,Card.class);
    }

    public void setDealerServiceHost(String dealerServiceHost) {
        this.dealerServiceHost = dealerServiceHost;
    }



    @Override
    public void getPlayerCards(Player player) {
        Card one=getCard();
        player.getPlayerCards().add(one);
        Card two=getCard();
        player.getPlayerCards().add(two);
        System.out.println(one);
        System.out.println(two);
    }
}
