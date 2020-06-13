package br.edu.faculdadealfa.projectfolhaofi.model.validation;

// handler (?) escuta os erros para passar um processo necessario
public class ErroValidacaoDto {
	private String campo;
	private String erro;

	public ErroValidacaoDto(String nome, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
}
