package br.fa7.spring.loja.exception;

public class EnderecoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 721371471265422002L;

	public EnderecoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnderecoNotFoundException(String message) {
		super(message);
	}
	
	

}
