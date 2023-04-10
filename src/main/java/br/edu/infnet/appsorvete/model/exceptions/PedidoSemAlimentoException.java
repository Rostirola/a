package br.edu.infnet.appsorvete.model.exceptions;

public class PedidoSemAlimentoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public PedidoSemAlimentoException(String mensagem) {
		super(mensagem);
	}

}
