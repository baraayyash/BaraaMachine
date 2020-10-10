package baraassignment.entities.cardsslots;

import java.util.ArrayList;

import baraassignment.entities.moneyslots.MoneySlot;
import baraassignment.entities.moneyslots.MoneySlotsOptions;

public class CardsSlot extends MoneySlot {
	
	public CardsSlot() {
		this.setName(MoneySlotsOptions.CARDS);
	}
	
	private ArrayList<Card> acceptedCards = new ArrayList<>();

	public ArrayList<Card> getAcceptedCards() {
		return acceptedCards;
	}

	public void setAcceptedCards(ArrayList<Card> acceptedCards) {
		this.acceptedCards = acceptedCards;
	}

}
