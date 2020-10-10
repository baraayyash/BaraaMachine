package baraassignment.entities;

import java.util.ArrayList;

import baraassignment.entities.cardsslots.CardsSlot;
import baraassignment.entities.moneyslots.MoneySlot;
import baraassignment.exceptions.ItemNotFoundException;
import baraassignment.machineslots.Item;
import baraassignment.machineslots.ItemsSlot;


public abstract class VendingMachine {
	
	private ArrayList<MoneySlot> moneySlots = new ArrayList<>();
	private ItemsSlot itemsSlot;
	private CardsSlot cardsSlot;

	/**
	 * This method is responsible for creating Slots and Items
	 */
	public abstract void inilizeMachine();
	
	/**
	 * Display SlotsOption where customer can use to pay : coins, notes, cards
	 */
	public void displaySlotsOptions() {
		System.out.println(" ------ you have these options to pay  ------");
		for (MoneySlot moneySlot : this.getMoneySlots()) {
			System.out.println(" ------ >  " + moneySlot.getName());
		}
		
		if (this.getCardSlot() != null ) {
			System.out.println(" ------ >  " + this.getCardSlot().getName());
		}
	}
	
	/**
	 * @param itemCode
	 * 
	 * Selects an item, will throw an Exception if the item is not valid or its empty 
	 * 
	 */
	public void selectItem(String itemCode) {
		Item selectedItem = this.itemsSlot.getItems().get(itemCode);
		if (selectedItem == null || this.itemsSlot.getInventory().get(selectedItem) == 0) {
			throw new ItemNotFoundException(itemCode);
		}
		
		this.itemsSlot.setSelectedItem(selectedItem);
		System.out.println("Item selected : " + selectedItem.getName() + " it's price : " + selectedItem.getPrice());
	}
	
	
	/**
	 * Will return the change to the customer if exist
	 */
	public  void returnChange() {
		// check if change should be returned
		
		this.getMoneySlots().forEach(slot -> {
			if (slot.getAmount() == 0) return;
			double changeToBeReturned = slot.getAmount() - this.getItemsSlot().getSelectedItem().getPrice();
			if (changeToBeReturned > 0) {
				System.out.println("please take your change : " + changeToBeReturned);
			}
			slot.setAmount(0.0);
		});
		
	}
	
	
	/**
	 * Drop the Selected Item to the customer
	 */
	public void dropItem() {
		this.getItemsSlot().takeItemOff(this.getItemsSlot().getSelectedItem());
	}
	
	public void displayItems() {
		System.out.println("Items in Snacks Vending Machine: ");
		this.getItemsSlot().getItems().entrySet().forEach(item -> {
			System.out.println("Item Name: " + item.getValue().getName() + " Number# " + item.getKey());
		});
	}
	
	/**
	 * This method is called on Abort. it will clean the Machine, return inserted money if needed.
	 */
	public void clean() {
		this.getMoneySlots().forEach(slot -> {
			
			if (slot.getAmount() > 0) {
				System.out.println(" Please take the money you inserted : " + slot.getAmount());
			}

			slot.setAmount(0.0);
		});		
		
		this.itemsSlot.setSelectedItem(null);
	}
	public ArrayList<MoneySlot> getMoneySlots() {
		return moneySlots;
	}
	public void setMoneySlots(ArrayList<MoneySlot> moneySlots) {
		this.moneySlots = moneySlots;
	}
	public ItemsSlot getItemsSlot() {
		return itemsSlot;
	}
	public void setItemsSlot(ItemsSlot machineSlot) {
		this.itemsSlot = machineSlot;
	}
	
	public CardsSlot getCardSlot() {
		return cardsSlot;
	}
	public void setCardSlot(CardsSlot cardSlot) {
		this.cardsSlot = cardSlot;
	}
}
