package slash.code.table.river;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
@Setter
public class River {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @OneToOne
    Card one;
    @OneToOne
    Card two;
    @OneToOne
    Card three;
    @OneToOne
    Card four;
    @OneToOne
    Card five;

    //  ArrayList<Card> riverCards;


}
