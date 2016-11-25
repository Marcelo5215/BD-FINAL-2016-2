package br.cic.unb.bd.integracao;

import br.cic.unb.bd.estrutura.OrgaoSuperior;

public interface OrgaoSuperiorDAO {
	
	public void salvar(OrgaoSuperior Osup);
	
	public void atualizar(OrgaoSuperior Osup);
	
	public void excluir(String s);
	
	public OrgaoSuperior pesquisar(String s);
}
