package baraassignment.entities.cardsslots;

import baraassignment.entities.coins.Money;

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
	
    @Override
    public boolean equals(Object o) {
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        if (!(o instanceof Money)) { 
            return false; 
        } 
          
        Card c = (Card) o; 
          
        // Compare the data members and return accordingly  
        return this.getId().equals(c.getId());
    } 
}
