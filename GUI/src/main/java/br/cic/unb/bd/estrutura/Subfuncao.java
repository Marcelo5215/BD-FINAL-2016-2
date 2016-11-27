package br.cic.unb.bd.estrutura;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "SUBFUNCAO")
public class Subfuncao {
	
	@Id
	@Column(name = "subFuncID")
	private int ID;
	
	@Column(name = "Nome", length = 50)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SUBFUNCAO_PROGRAMA", joinColumns = {@JoinColumn(name="subfuncao_id")}, inverseJoinColumns = {@JoinColumn(name = "programa_id")})
	private List<Programa> programas;

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

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}
	
	
}
