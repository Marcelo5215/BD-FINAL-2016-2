package br.cic.unb.bd.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.cic.unb.bd.estrutura.Subfuncao;

public class SubfuncaoDAO implements br.cic.unb.bd.integracao.SubfuncaoDAO{

	public void salvar(Subfuncao sub) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(sub.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(sub);
		}
		else{
			//se ja tiver no bd, atualiza
			sub = em.merge(sub);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Subfuncao sub = pesquisarPorID(id);
		if(sub != null){
			em.remove(em.contains(sub) ? sub : em.merge(sub));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public Subfuncao pesquisarPorID(int id) {
		String consulta = "SELECT * FROM SUBFUNCAO sub WHERE sub.subFuncID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Subfuncao> sub = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (sub == null || sub.size()==0){
			return null;
		}
		return sub.get(0);
	}

	public List<Subfuncao> pesquisarPorNome(String s) {
		String consulta = "SELECT * FROM SUBFUNCAO sub WHERE sub.Nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Subfuncao> subs = em.createNamedQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (subs == null || subs.size()==0){
			return null;
		}
		return subs;
	}

}
