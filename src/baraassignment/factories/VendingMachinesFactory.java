package baraassignment.factories;

import baraassignment.entities.SnackVendingMachine;
import baraassignment.entities.VendingMachine;
import baraassignment.entities.VendingMachinesTypes;
import baraassignment.exceptions.VendingMachineNotSupprted;

public class VendingMachinesFactory {

	public static VendingMachine getVendingMachine(VendingMachinesTypes type) {
		switch (type) {
			case SNACKS: return new SnackVendingMachine();
			default : throw new VendingMachineNotSupprted();
		}
	}
	
}
