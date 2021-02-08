package slash.code.table.game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import slash.code.table.player.Player;

import slash.code.table.river.River;

import javax.persistence.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Game {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    @OneToOne
    River river;

    Integer sb = 0;

    Integer bb = 0;

    @OneToOne
    Player player1;
    @OneToOne
    Player player2;
    @OneToOne
    Player player3;
    @OneToOne
    Player player4;

//    @OneToMany
//    @JoinTable(name = "game_player",joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
//    ArrayList<Player>players;


//    @OneToMany
//    ArrayList<Player>players;


    public Integer getSb() {
        return sb;
    }

    public void setSb(Integer sb) {
        this.sb = sb;
    }

    public Integer getBb() {
        return bb;
    }

    public void setBb(Integer bb) {
        this.bb = bb;
    }
}
