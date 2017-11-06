package crud.rest.exception;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 8026550017890280206L;

	private String mensagem;
	
	public NegocioException(String msg) {
		this.setMensagem(msg);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
