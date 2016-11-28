package br.cic.unb.bd.estrutura;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa {
	
	@Id
	@Column
	private int CPF;
	
	@Column(name = "nome", length = 50)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orgID_ORG_SUPERIOR")
	private OrgaoSuperior superior;

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrgaoSuperior getSuperior() {
		return superior;
	}

	public void setSuperior(OrgaoSuperior superior) {
		this.superior = superior;
	}
}
