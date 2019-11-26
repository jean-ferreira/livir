package br.com.promove.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESTIMOS")
public class Emprestimo {

	@Id
	@GeneratedValue
	@Column(name = "id_emprestimo")
	private int idEmprestimo;

	@Column(name = "data_retirada")
	private Date dataRetirada;

	@Column(name = "data_devolucao")
	private Date dataDevolucao;

	@Column(name = "condicao_livro_retirada")
	private String condicaoLivroRetirada;

	@Column(name = "condicao_livro_devolucao")
	private String condicaoLivroDevolucao;

	@Column(name = "qnt_dias_atraso")
	private int qntDiasAtraso;

	@Column(name = "valor_multa")
	private double valorMulta;

	@Column(name = "status_pagamento")
	private String statusPagamento;

	@OneToOne
	@JoinColumn(name = "id_renovacao")
	private Renovacao renovacao;

	@Column(name = "status_cadastro") // bloqueado/desbloqueado para emprestimo
	private boolean statusCadastro;

	@Column(name = "observacoes")
	private String observacoes;

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getCondicaoLivroRetirada() {
		return condicaoLivroRetirada;
	}

	public void setCondicaoLivroRetirada(String condicaoLivroRetirada) {
		this.condicaoLivroRetirada = condicaoLivroRetirada;
	}

	public String getCondicaoLivroDevolucao() {
		return condicaoLivroDevolucao;
	}

	public void setCondicaoLivroDevolucao(String condicaoLivroDevolucao) {
		this.condicaoLivroDevolucao = condicaoLivroDevolucao;
	}

	public int getQntDiasAtraso() {
		return qntDiasAtraso;
	}

	public void setQntDiasAtraso(int qntDiasAtraso) {
		this.qntDiasAtraso = qntDiasAtraso;
	}

	public double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public String getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public boolean isStatusCadastro() {
		return statusCadastro;
	}

	public void setStatusCadastro(boolean statusCadastro) {
		this.statusCadastro = statusCadastro;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Renovacao getRenovacao() {
		return renovacao;
	}

	public void setRenovacao(Renovacao renovacao) {
		this.renovacao = renovacao;
	}

}
