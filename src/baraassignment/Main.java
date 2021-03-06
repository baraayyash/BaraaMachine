package baraassignment;

import java.util.Scanner;

import baraassignment.entities.VendingMachine;
import baraassignment.entities.VendingMachinesTypes;
import baraassignment.entities.cardsslots.Card;
import baraassignment.entities.cardsslots.CardsSlot;
import baraassignment.entities.coins.Money;
import baraassignment.entities.moneyslots.MoneySlot;
import baraassignment.exceptions.ItemNotFoundException;
import baraassignment.exceptions.ProccessAbortedException;
import baraassignment.factories.CardsFactory;
import baraassignment.factories.MoneyFactory;
import baraassignment.factories.VendingMachinesFactory;


/**
 * @author Baraa
 * 
 * Main entry to the program, responsible for managing the machine and customers. 
 *
 */
public class Main {

	static Scanner sc = new Scanner(System.in);	

	public static void main(String[] args) {
		
		// For now only Snacks is available. but i made it easy to support new ones !
		VendingMachine snacksVendingMachine = VendingMachinesFactory.getVendingMachine(VendingMachinesTypes.SNACKS);
		
		try {
			
			System.out.println("**************************");
			// Display list of items, in our case, snacks (name + id)
			snacksVendingMachine.displayItems();
			System.out.println("**************************");
	
			while (true) {
				// will get the item id from the user
				String itemSelected = getSelectedItemFromUser();
				try {
					// make the Machine knows which item is selected
					snacksVendingMachine.selectItem(itemSelected);
					break;
				} catch (ProccessAbortedException e) {
					throw e;
				} catch (ItemNotFoundException e) {
					System.out.println("the item you selected is not found");
				} catch (Exception e) {
					throw e;
				}
			}
			
			// Take money from customer
			insertMoneyUsingSlot(snacksVendingMachine);
			
			// Return change to customer of found
			snacksVendingMachine.returnChange();
			
			// Drop the selected item to the storage so the customer can take it
			snacksVendingMachine.dropItem();
			
		} catch (ProccessAbortedException e) {
			System.out.println("!************* Proccess is aborted ***********!");
			snacksVendingMachine.clean();
		} catch (Exception e) {
			System.out.println("!************* Something went wrong ***********!");
			e.printStackTrace();
			snacksVendingMachine.clean();
			
		} finally {
			sc.close();
		}
		
	}

	/**
	 * Get the code for selected Item, or ABORT
	 * 
	 * @return input
	 */
	private static String getSelectedItemFromUser() {
		System.out.println("please enter the item's code to select it");
		System.out.println("Or to abort please enter : ABORT");

		String input = sc.nextLine();
		
		if (input.equals("ABORT")) {
			throw new ProccessAbortedException();
		}
		
		return input;
	}

	
	/**
	 * @param snacksVendingMachine
	 * 
	 * Customer will determine which slot he wants to use
	 * Money will be inserted using chosen slot 
	 * 
	 */
	private static void insertMoneyUsingSlot(VendingMachine snacksVendingMachine) {
		 
		System.out.println();
		System.out.println("**************************");
		
		snacksVendingMachine.displaySlotsOptions();
		// TODO : support hybrid payment?
		System.out.println("select one option to pay, or to abort enter : ABORT");
		String input = sc.nextLine();
		MoneySlot moneySlot = null;
		CardsSlot cardsSlot = null;
		while (moneySlot == null && cardsSlot == null) {
			
			if (input.equals("ABORT")) {
				throw new ProccessAbortedException();
			}
			
			if (input.equals("CARDS") && snacksVendingMachine.getCardSlot() != null) {
				cardsSlot = snacksVendingMachine.getCardSlot();
				break;
			}
			
			for ( MoneySlot slot : snacksVendingMachine.getMoneySlots()) {

				if (slot.getName().equals(input)) {
					moneySlot = slot;
				}
			}
			
			if (moneySlot == null && cardsSlot == null) {
				System.out.println("the option you selected is not valid, select one option to pay, or to abort enter : ABORT");
				input = sc.nextLine();
			}
		}
		
		System.out.println("**************************");
		System.out.println("");
		
		if (cardsSlot != null) {
			insertMoney(snacksVendingMachine.getItemsSlot().getSelectedItem().getPrice(), cardsSlot);
		} else {
			insertMoney(snacksVendingMachine.getItemsSlot().getSelectedItem().getPrice(), moneySlot);
		}
	}

	
	/**
	 * Insert money using coins or notes
	 * 
	 * @param price
	 * @param moneySlot
	 */
	private static void insertMoney(double price, MoneySlot moneySlot) {
		System.out.println("supported money  with Currency " + moneySlot.getCurrency());
		moneySlot.getAcceptedMoney().forEach( acceptedMoney -> {
			System.out.print(acceptedMoney.getId() + "    ");
		});
		
		while (moneySlot.getAmount() < price) {
			System.out.println("insert your money from accepted list or to abort enter : ABORT ");
			String input = sc.nextLine();
			if (input.equals("ABORT")) {
				throw new ProccessAbortedException();
			}
			Money money = MoneyFactory.getAcceptedMoney(input);
			moneySlot.insert(money);
		}
		
	}

	
	/**
	 * Insert money using cards
	 * 
	 * @param price
	 * @param cardsSlot
	 */
	private static void insertMoney(double price, CardsSlot cardsSlot) {
		System.out.println("supported Cards : " );
		cardsSlot.getAcceptedCards().forEach( card -> {
			System.out.print( "  card name  :  " + card.getName() + " id to select : " + card.getId());
		});
		
		Card card = null;
		while (card != null) {
			System.out.println("insert your card accepted list or to abort enter : ABORT ");
			String input = sc.nextLine();
			if (input.equals("ABORT")) {
				throw new ProccessAbortedException();
			}
			card = CardsFactory.getAcceptedCard(input);
		}
		
		// take the money from the card
		card.charge(price);
	}



}
