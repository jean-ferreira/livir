package br.com.promove.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RENOVACOES")
public class Renovacao {
	
	@Id
	@GeneratedValue
	@Column(name = "id_renovacao")
	private int idRenovacao;
	
	@Column(name = "data_atual")
	private Date dataAtual;
	
	@Column(name = "data_renovada")
	private Date dataRenovada;

	public int getIdRenovacao() {
		return idRenovacao;
	}

	public void setIdRenovacao(int idRenovacao) {
		this.idRenovacao = idRenovacao;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Date getDataRenovada() {
		return dataRenovada;
	}

	public void setDataRenovada(Date dataRenovada) {
		this.dataRenovada = dataRenovada;
	}
	
}
