package br.cic.unb.bd.integracao.jpa.queries;

import br.cic.unb.bd.estrutura.Pagamento;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class PessoaPagamento {
	private String pessoaNome;
	private java.util.Date data;
	private double valor;
	
	public String getPessoaNome() {
		return pessoaNome;
	}
	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}
	public java.util.Date getData() {
		return data;
	}
	public void setData(java.util.Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}
