package baraassignment.machineslots;

public class SnacksSlot extends ItemsSlot {

	public SnacksSlot() {
		String rows[] = {"A", "B", "C", "D", "E"};
		for (String row : rows) {
			for (int i = 1; i <= 5; i++) {
				String id = row + i;
				Item item = new Item("Dummy name " + id, id, 0.50);
				this.getItems().put(id, item);
				this.getInventory().put(item, 5);
			}
		}
	}
}
