package slash.code.dealer.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import slash.code.dealer.cards.Deck;
import slash.code.dealer.config.JmsConfig;

import javax.jms.Message;

@Component
public class NewGameListener {

    DeckService deckService;
    JmsTemplate jmsTemplate;

    public NewGameListener(DeckService deckService, JmsTemplate jmsTemplate) {
        this.deckService = deckService;
        this.jmsTemplate = jmsTemplate;
    }


    @JmsListener(destination = JmsConfig.NEW_GAME_QUEUE)
    public void newGameListener(@Payload Integer players,
                                @Headers MessageHeaders headers, Message message) {
        if (players > 1) {
            Deck deck = deckService.prepareDeck();
            jmsTemplate.convertAndSend(JmsConfig.SMALL_BLIND_GAME, 5);
            System.out.println("small blind launch");
            jmsTemplate.convertAndSend(JmsConfig.BIG_BLIND_GAME, 10);
            System.out.println("big blind launch");
            System.out.println(deck);
        }
    }
}
