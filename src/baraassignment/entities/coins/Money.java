package baraassignment.entities.coins;

public abstract class Money {

	private String id;
	private String currency;
	private double amount;
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
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
          
        Money c = (Money) o; 
          
        // Compare the data members and return accordingly  
        return this.getId().equals(c.getId());
    } 

}
