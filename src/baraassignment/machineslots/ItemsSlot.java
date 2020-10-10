package baraassignment.machineslots;

import java.util.HashMap;
import java.util.Map;

public abstract class ItemsSlot {

	private Map<String, Item> items = new HashMap<String, Item>();
	private Map<Item, Integer> inventory = new HashMap<Item, Integer>();
	private Item selectedItem;
	
	
	public void takeItemOff(Item item) {
		
		int numOfItem = inventory.get(item);
		inventory.put(item, --numOfItem);
		
		System.out.println("please take the item " + item.getName() + " from storage case ");
		this.setSelectedItem(null);
	}


	public Map<Item, Integer> getInventory() {
		return inventory;
	}


	public void setInventory(Map<Item, Integer> inventory) {
		this.inventory = inventory;
	}


	public Map<String, Item> getItems() {
		return items;
	}


	public void setItems(Map<String, Item> items) {
		this.items = items;
	}


	public Item getSelectedItem() {
		return selectedItem;
	}


	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
}
