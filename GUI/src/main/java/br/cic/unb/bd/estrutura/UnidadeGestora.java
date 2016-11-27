package br.cic.unb.bd.estrutura;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDADE_GESTORA")
public class UnidadeGestora {
	
	@Id
	@Column(name = "ungID")
	private int ID;
	
	@Column(name = "Nome", length = 50)
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcID_FUNCAO")
	private Funcao funcao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orsubID_ORG_SUBORDINADO")
	private OrgaoSubordinado orgSub;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public OrgaoSubordinado getOrgSub() {
		return orgSub;
	}

	public void setOrgSub(OrgaoSubordinado orgSub) {
		this.orgSub = orgSub;
	}
	
	
}
