package baraassignment.entities;

import baraassignment.entities.cardsslots.CardsSlot;
import baraassignment.entities.cardsslots.DebitCard;
import baraassignment.entities.coins.FiftyDollars;
import baraassignment.entities.coins.OneDollar;
import baraassignment.entities.coins.TenCents;
import baraassignment.entities.coins.TwentyDollars;
import baraassignment.entities.coins.fiftyCents;
import baraassignment.entities.coins.twentyCents;
import baraassignment.entities.moneyslots.CoinsSlot;
import baraassignment.entities.moneyslots.MoneySlot;
import baraassignment.entities.moneyslots.NotesSlot;
import baraassignment.machineslots.ItemsSlot;
import baraassignment.machineslots.SnacksSlot;

/**
 * @author Baraa
 *
 * SnackVendingMachine
 * 
 */
public class SnackVendingMachine extends VendingMachine {

	public SnackVendingMachine() {
		this.inilizeMachine();
	}

	@Override
	public void inilizeMachine() {
		this.buildMoneySlots();
		this.buildItemsSlot();
	}
	
	private void buildItemsSlot() {
		this.setItemsSlot((ItemsSlot) new SnacksSlot());
	}

	private void buildMoneySlots() {
		buildCoinSlot();
		buildCardsSlot();
		buildNotesSlot();
	}

	private void buildCoinSlot() {
		MoneySlot coinsSlot = new CoinsSlot();
		coinsSlot.getAcceptedMoney().add(new fiftyCents());
		coinsSlot.getAcceptedMoney().add(new twentyCents());
		coinsSlot.getAcceptedMoney().add(new TenCents());
		coinsSlot.getAcceptedMoney().add(new OneDollar());
		this.getMoneySlots().add(coinsSlot);
	}

	private void buildNotesSlot() {
		NotesSlot notesSlot = new NotesSlot();
		notesSlot.getAcceptedMoney().add(new FiftyDollars());
		notesSlot.getAcceptedMoney().add(new TwentyDollars());
		this.getMoneySlots().add(notesSlot);
	}

	private void buildCardsSlot() {
		CardsSlot cardSlot = new CardsSlot();
		cardSlot.getAcceptedCards().add(new DebitCard());
		this.setCardSlot(cardSlot);
	}


}
