package baraassignment.entities.cardsslots;


public abstract class Card {

	private String name;
	private String id;
	
	public void charge(double amount) {
		// TODO validate card status ? balance?
		System.out.println("Your card has been chared " + amount);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
