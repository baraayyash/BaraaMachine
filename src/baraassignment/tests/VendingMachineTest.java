package baraassignment.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import baraassignment.entities.VendingMachine;
import baraassignment.entities.VendingMachinesTypes;
import baraassignment.exceptions.VendingMachineNotSupprted;
import baraassignment.factories.VendingMachinesFactory;

public class VendingMachineTest {

	@Test
	public void testNotSupportedVendingMachineTypes() {
		try {
			VendingMachinesFactory.getVendingMachine(VendingMachinesTypes.COFFE);
		} catch (VendingMachineNotSupprted e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testSupportedVendingMachineTypes() {
		try {
			VendingMachinesFactory.getVendingMachine(VendingMachinesTypes.SNACKS);
		} catch (VendingMachineNotSupprted e) {
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Test
	public void testAbortBeforeInsertingMoney() {
		try {
			VendingMachine snacksMachine = VendingMachinesFactory.getVendingMachine(VendingMachinesTypes.SNACKS);
			snacksMachine.selectItem("A1");
			snacksMachine.clean();
			assertEquals(null, snacksMachine.getItemsSlot().getSelectedItem());
		}  catch (Exception e) {
			assertTrue(false);
		}
	}
	
	// TODO : more tests
 }
