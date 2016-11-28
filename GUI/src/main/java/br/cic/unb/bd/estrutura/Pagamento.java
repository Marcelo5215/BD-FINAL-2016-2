package br.cic.unb.bd.estrutura;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DOCPAG")
public class Pagamento {
	
	@Id
	@Column(name = "docpagID")
	private int ID;
	
	@Column(name = "nome", length = 50)
	private String name;
	
	@Column(name = "Valor")
	private double valor;

	private int gestao;
	
	@Column(name = "data")
	@Temporal(value = TemporalType.DATE)
	private java.util.Date data;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CPF_PESSOA")
	private Pessoa pessoa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acaoID_ACAO")
	private Acao acao;
	
	public int getGestao() {
		return gestao;
	}

	public void setGestao(int gestao) {
		this.gestao = gestao;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
