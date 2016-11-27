package br.cic.unb.bd.estrutura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "ORG_SUPERIOR")
public class OrgaoSuperior {
	
	@Id
	@Column(name = "orgID")
	private int orgID;
	
	@Column(name = "Nome", length = 50)
	private String name;

	public int getID() {
		return orgID;
	}

	public void setID(int iD) {
		orgID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
