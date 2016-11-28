package br.cic.unb.bd.estrutura;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACAO")
public class Acao {
	
	@Id
	@Column(name = "acaoID")
	private int ID;
	
	@Column(name = "nome", length = 200)
	private String name;
	
	@Column(name = "linguagemcidada", length = 200)
	private String linguagem;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "progID_PROGRAMA")
	private Pagamento pagamento;

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

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
