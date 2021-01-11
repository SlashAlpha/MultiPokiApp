package slash.code.dealer.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import slash.code.dealer.cards.Card;
import slash.code.dealer.cards.Deck;

@CrossOrigin("*")
@RequestMapping("/api/v1/dealer/")
@RestController
public class DealerController {
    Deck deck ;
    Integer count=0;



    public DealerController(Deck deck) {
        this.deck = deck;
    }

//    @GetMapping("first")
//    public String firstWave(){
//        if(!first){
//        deck.shuffleCard(1);
//        deck.riverFill();
//        deck.riverFill();
//        first=true;
//            river.cards= deck.riverFill();
//            riverRepository.save(river);
//
//        }
//        return this.river.cards;
//    }
//    @GetMapping("second")
//    public String secondWave(){
//        if(!second && first){
//            second=true;
//            river.cards= deck.riverFill();
//            riverRepository.save(river);
//
//        }return river.cards ;
//    }
//    @GetMapping("third")
//    public String thirdWave(){
//        if(!third && second){
//            third=true;
//            river.cards= deck.riverFill();
//            riverRepository.save(river);
//
//        }return river.cards ;
//    }


    @GetMapping("river/card")
    public Card getRiverCard(){

            Card card=deck.getCards().get(0);
            deck.getCards().remove(card);

            return card;

    }
    @GetMapping("player/card")
    public Card getPlayerCard(){

            Card card=deck.getCards().get(0);
            deck.getCards().remove(card);

            return card;

    }


}
