package model.exceptions;

public class DomainException extends RuntimeException{ //Runtime não obriga o tratamento
														//Exception precisa ser tratada.
	
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
}
