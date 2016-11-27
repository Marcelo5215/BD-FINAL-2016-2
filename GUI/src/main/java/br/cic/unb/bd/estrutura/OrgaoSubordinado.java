package br.cic.unb.bd.estrutura;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORG_SUBORDINADO")
public class OrgaoSubordinado {
	
	@Id
	@Column(name = "orsubID")
	private int orsubID;
	
	@Column(name = "Nome", length = 50)
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orgID_ORG_SUPERIOR")
	private OrgaoSuperior superior;

	public OrgaoSuperior getSuperior() {
		return superior;
	}

	public void setSuperior(OrgaoSuperior superior) {
		this.superior = superior;
	}

	public int getID() {
		return orsubID;
	}

	public void setID(int iD) {
		orsubID = iD;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}
	
	
}
