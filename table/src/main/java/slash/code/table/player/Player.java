package slash.code.table.player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slash.code.table.Card;

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




    ArrayList<Card>playerCards;


}
