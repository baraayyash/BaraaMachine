package baraassignment.factories;

import baraassignment.entities.cardsslots.Card;
import baraassignment.entities.cardsslots.DebitCard;
import baraassignment.entities.cardsslots.UnKnownCard;

public class CardsFactory {
	public static Card getAcceptedCard(String cardId) {
		switch (cardId) {
			case "DEBIT" : return new DebitCard();
			default : return new UnKnownCard();
		}
	}
}
