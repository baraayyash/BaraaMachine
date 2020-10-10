package baraassignment.exceptions;

public class VendingMachineNotSupprted  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VendingMachineNotSupprted() {
		super("the selected machine is not supprted");
	}
	
}
