package slash.code.table.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slash.code.table.game.Game;
import slash.code.table.river.Card;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Player {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    String name;
    Integer age;
    Integer gamePlayed;
    Integer bet;
    Integer success;
    Integer hoursPlayed;
    Integer bank;
    Integer score;
    boolean dealer = false;
    boolean sb = false;
    boolean bb = false;
    int gameOrder = 0;

    @OneToOne
    Card one;
    @OneToOne
    Card two;

    public void setOne(Card one) {
        this.one = one;
    }

    public void setTwo(Card two) {
        this.two = two;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public void setSb() {
        this.sb = sb;
    }

    public void setBb(boolean bb) {
        this.bb = bb;
    }

    public Integer betting(Integer bet) {
        this.bank = bank - bet;
        this.bet = bet;
        return bet;
    }

}


