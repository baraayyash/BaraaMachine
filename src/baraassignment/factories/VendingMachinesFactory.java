package baraassignment.factories;

import baraassignment.entities.SnackVendingMachine;
import baraassignment.entities.VendingMachine;
import baraassignment.entities.VendingMachinesTypes;

public class VendingMachinesFactory {

	public static VendingMachine getVendingMachine(VendingMachinesTypes type) {
		switch (type) {
			case SNACKS: return new SnackVendingMachine();
			default : return null; // throw execption
		}
	}
	
}
