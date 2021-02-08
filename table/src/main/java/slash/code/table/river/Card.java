package slash.code.table.river;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import slash.code.table.player.Player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    String color;
    Integer value;
    Integer faceVal;
    String description;


    public Card(String color, Integer value, Integer faceVal, String description) {
        this.color = color;
        this.value = value;
        this.faceVal = faceVal;
        this.description = description;


    }

    @Override
    public String toString() {
        if (description != "") {
            return description + " of " + color;
        } else {
            return value + " of " + color;
        }
    }

    public Integer getValue() {
        return value;
    }


    public Integer getFaceVal() {
        return faceVal;
    }


    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

}
