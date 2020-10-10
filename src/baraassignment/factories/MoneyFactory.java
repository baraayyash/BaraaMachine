package baraassignment.factories;

import baraassignment.entities.coins.FiftyDollars;
import baraassignment.entities.coins.Money;
import baraassignment.entities.coins.OneDollar;
import baraassignment.entities.coins.TenCents;
import baraassignment.entities.coins.TwentyDollars;
import baraassignment.entities.coins.UnKnownMoney;
import baraassignment.entities.coins.fiftyCents;
import baraassignment.entities.coins.twentyCents;

public class MoneyFactory {

	public static Money getAcceptedMoney(String moneyId) {
		switch (moneyId) {
			case "$1": return new OneDollar();
			case "50c" : return new fiftyCents();
			case "$50" : return new FiftyDollars();
			case "10c" : return new TenCents();
			case "20c" : return new twentyCents();
			case "$20" : return new TwentyDollars();

			default : return new UnKnownMoney();
		}
	}
}
