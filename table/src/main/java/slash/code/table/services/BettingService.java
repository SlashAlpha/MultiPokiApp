package slash.code.table.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import slash.code.table.Table;
import slash.code.table.config.JmsConfig;
import slash.code.table.game.Game;

import javax.jms.Message;
import java.util.UUID;

@Getter
@Component
public class BettingService {

    GameService gameService;
    Integer smallBlind = 0;
    Integer bigBlind = 0;


    public BettingService(GameService gameService) {
        this.gameService = gameService;

    }


    @JmsListener(destination = JmsConfig.SMALL_BLIND_GAME)
    public void smallBlindListener(@Payload Integer blind,
                                   @Headers MessageHeaders headers, Message message) {

        smallBlind = blind;


    }

    //
    @JmsListener(destination = JmsConfig.BIG_BLIND_GAME)
    public void bigBlindListener(@Payload Integer blind,
                                 @Headers MessageHeaders headers, Message message) {
        bigBlind = blind;

    }
}
