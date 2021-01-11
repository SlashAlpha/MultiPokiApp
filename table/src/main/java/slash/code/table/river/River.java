package slash.code.table.river;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slash.code.table.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class River {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    ArrayList<Card> riverCards;


}
