package br.edu.faculdadealfa.projectfolhaofi.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

// tabela pai do processo de log
@MappedSuperclass
public class TemplateTable {
	
	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@NotNull
	private Integer codigoUsuario;

	@NotNull
	private LocalDateTime dataAlteracao;

}
