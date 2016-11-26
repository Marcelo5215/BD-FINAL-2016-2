package br.cic.unb.bd.integracao.jpa;

import br.cic.unb.bd.estrutura.Pessoa;

import java.util.List;

import javax.persistence.EntityManager;

public class PessoaDAO implements br.cic.unb.bd.integracao.PessoaDAO{

	public void salvar(Pessoa pe) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorCPF(pe.getCPF()) == null){
			//se nao tiver no bd, cria
			em.persist(pe);
		}
		else{
			//se ja tiver no bd, atualiza
			pe = em.merge(pe);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
		
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Pessoa pessoa = pesquisarPorCPF(id);
		if(pessoa != null){
			em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public Pessoa pesquisarPorCPF(int cpf) {
		String consulta = "SELECT * FROM PESSOA pe WHERE pe.CPF = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Pessoa> pessoa = em.createNamedQuery(consulta).setParameter("pmtID", cpf).getResultList();
		
		if (pessoa == null || pessoa.size()==0){
			return null;
		}
		return pessoa.get(0);
	}

	public List<Pessoa> pesquisarPorNome(String nome) {
		String consulta = "SELECT * FROM PESSOA pe WHERE pe.nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pessoa> pessoas = em.createNamedQuery(consulta).setParameter("pmtNome", nome).getResultList();
		
		if (pessoas == null || pessoas.size()==0){
			return null;
		}
		return pessoas;
	}

	public List<Pessoa> pesquisarPorOrgao(int id) {
		String consulta = "SELECT * FROM PESSOA pe WHERE pe.orgID_ORG_SUPERIOR = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pessoa> pessoas = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (pessoas == null || pessoas.size()==0){
			return null;
		}
		return pessoas;
	}
	
}
