package baraassignment.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import baraassignment.entities.coins.Money;
import baraassignment.entities.coins.TenCents;
import baraassignment.entities.moneyslots.CoinsSlot;
import baraassignment.entities.moneyslots.MoneySlot;
import baraassignment.factories.MoneyFactory;

public class MoneySlotsTest {

	// TODO : add tests to the money slot
	
	@Test
	public void testAddTenCents() {
		MoneySlot moneySlot = new CoinsSlot();
		Money money = MoneyFactory.getAcceptedMoney("10c");
		System.out.println(money.getId());
		moneySlot.getAcceptedMoney().add(new TenCents());
		moneySlot.insert(money);
		assertEquals(.1, money.getAmount());
	}
	
}
