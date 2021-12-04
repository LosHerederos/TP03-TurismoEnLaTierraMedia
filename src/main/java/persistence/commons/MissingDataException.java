package persistence.commons;

public class MissingDataException extends RuntimeException {

	private static final long serialVersionUID = -5058643761768993356L;
	
	public MissingDataException(Exception e) {
		super(e);
	}

}
