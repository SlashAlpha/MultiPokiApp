package slash.code.dealer.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import slash.code.dealer.cards.Deck;
import slash.code.dealer.config.JmsConfig;

@Service
@Getter
public class DeckServices implements DeckService {


    Deck deck;
    JmsTemplate jmsTemplate;

    public DeckServices(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Deck prepareDeck() {
        deck = new Deck();
        return deck;
    }
}
