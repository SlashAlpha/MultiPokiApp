package slash.code.table.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import slash.code.table.player.Player;
import slash.code.table.river.Card;
import slash.code.table.river.CardRepository;

@Service
public class CardServices implements CardService {

    RestTemplate restTemplate;
    public final static String CARD_PATH_V1 = "http://localhost:8080/api/v1/dealer/card";

    CardRepository cardRepository;


    public CardServices(RestTemplateBuilder restTemplate, CardRepository cardRepository) {
        this.restTemplate = restTemplate.build();
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getOne() {

        Card card = restTemplate.getForObject(CARD_PATH_V1, Card.class);

        cardRepository.save(card);
        return card;
    }
}
