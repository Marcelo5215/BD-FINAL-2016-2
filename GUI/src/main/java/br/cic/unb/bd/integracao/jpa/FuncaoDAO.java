package br.cic.unb.bd.integracao.jpa;

import br.cic.unb.bd.estrutura.Funcao;

import java.util.List;

import javax.persistence.EntityManager;

public class FuncaoDAO implements br.cic.unb.bd.integracao.FuncaoDAO{

	public void salvar(Funcao f) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(f.getId()) == null){
			//se nao tiver no bd, cria
			em.persist(f);
		}
		else{
			//se ja tiver no bd, atualiza
			f = em.merge(f);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
		
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Funcao funcao = pesquisarPorID(id);
		if(funcao != null){
			em.remove(em.contains(funcao) ? funcao : em.merge(funcao));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
		
	}

	public List<Funcao> pesquisarPorNome(String s) {
		String consulta = "SELECT * FROM FUNCAO f WHERE f.Nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Funcao> funcoes = em.createNamedQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (funcoes == null || funcoes.size()==0){
			return null;
		}
		return funcoes;
	}

	public Funcao pesquisarPorID(int id) {
		String consulta = "SELECT * FROM FUNCAO f WHERE f.funcID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Funcao> funcao = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (funcao == null || funcao.size()==0){
			return null;
		}
		return funcao.get(0);
	}

	
}
