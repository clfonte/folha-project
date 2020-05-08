package br.edu.faculdadealfa.projectfolhaofi.model.process;

import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoEvento;

public class Evento {
	private String descricao;
	private Double valor;
	private TipoEvento tipoEvento;
	
	public Evento(String descricao, Double valor, TipoEvento tipoEvento) {
		this.descricao = descricao;
		this.valor = valor;
		this.tipoEvento = tipoEvento;
	}
	
	public Evento() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public String toString() {
		return descricao + " - " + tipoEvento + " R$" + valor ;
	}

}
