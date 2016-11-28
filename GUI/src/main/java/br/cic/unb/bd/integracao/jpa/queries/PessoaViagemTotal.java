package br.cic.unb.bd.integracao.jpa.queries;

public class PessoaViagemTotal {
	private String nome;
	private Long viagens;
	private Integer CPF;
	
	public Integer getCpf() {
		return CPF;
	}
	public void setCpf(Integer cpf) {
		this.CPF = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getViagens() {
		return viagens;
	}
	public void setViagens(Long viagens) {
		this.viagens = viagens;
	}
	
	
}
