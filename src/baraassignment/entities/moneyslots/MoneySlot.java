package baraassignment.entities.moneyslots;

import java.util.ArrayList;

import baraassignment.entities.coins.Money;

public abstract class MoneySlot {

	private String currency = "USD";
	private double amount = 0.0;
	private ArrayList<Money> acceptedMoney = new ArrayList<>();
	private String name;
	
	public void insert(Money money) {
		if ( ! acceptedMoney.contains(money)) {
			System.out.println("the inserted money is not supported. it wasn't count, and flushed.");
			return;
		} 
		
		amount+=money.getAmount();
		System.out.println("your balance : " + amount);
	}
	

	public String getName() {
		return name;
	}

	public void setName(MoneySlotsOptions option) {
		this.name = option.toString();
	}

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

	public ArrayList<Money> getAcceptedMoney() {
		return acceptedMoney;
	}

	public void setAcceptedMoney(ArrayList<Money> acceptedMoney) {
		this.acceptedMoney = acceptedMoney;
	}
	
}
