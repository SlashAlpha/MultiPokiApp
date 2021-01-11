package slash.code.dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import slash.code.dealer.cards.Deck;

@SpringBootApplication
public class DealerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerApplication.class, args);

		Deck deck=new Deck();
		System.out.println(deck.toString());
	}

}
