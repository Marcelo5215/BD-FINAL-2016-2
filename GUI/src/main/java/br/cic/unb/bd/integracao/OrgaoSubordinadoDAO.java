package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.OrgaoSubordinado;

public interface OrgaoSubordinadoDAO {
	
	public void salvar(OrgaoSubordinado Osub);
	
	public void atualizar(OrgaoSubordinado Osub);
	
	public void excluir(String s);
	
	public OrgaoSubordinado pesquisar(String s);
	
}
