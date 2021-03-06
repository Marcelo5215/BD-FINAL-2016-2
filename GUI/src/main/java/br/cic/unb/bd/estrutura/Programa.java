package br.cic.unb.bd.estrutura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMA")
public class Programa {
	
	@Id
	@Column(name = "progID")
	private int ID;
	
	@Column(name = "Nome", length = 50)
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
