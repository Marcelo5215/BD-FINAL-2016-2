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
@Table(name = "FUNCAO")
public class Funcao {
	
	@Id
	@Column(name = "funcID")
	private int id;
	
	@Column(name = "Nome", length = 50)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FUNC_SUBFUNC", joinColumns = {@JoinColumn(name="funcID_FUNCAO")}, inverseJoinColumns = {@JoinColumn(name = "subFuncID_SUBFUNCAO")})
	private List<Subfuncao> subs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subfuncao> getSubs() {
		return subs;
	}

	public void setSubs(List<Subfuncao> subs) {
		this.subs = subs;
	}
	
	
}
