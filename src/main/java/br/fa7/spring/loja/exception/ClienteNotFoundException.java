package br.fa7.spring.loja.exception;

public class ClienteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3139824075792408332L;

	public ClienteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteNotFoundException(String message) {
		super(message);
	}
	
	

}
