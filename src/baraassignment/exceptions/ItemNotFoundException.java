package baraassignment.exceptions;

public class ItemNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(String id) {
		super("the selected item is not found");
	}
	
}
