package br.cic.unb.bd.estrutura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "ORG_SUPERIOR")
public class OrgaoSuperior {
	
	@Id
	@Column(name = "orsupID")
	private int ID;
	
	@Column(name = "Nome", length = 15)
	private String name;

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
	
}
