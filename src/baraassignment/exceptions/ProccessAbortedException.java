package baraassignment.exceptions;

public class ProccessAbortedException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProccessAbortedException() {
		super("the proccess was aborted by user");
	}
	
}
