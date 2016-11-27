package br.cic.unb.bd.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.cic.unb.bd.estrutura.OrgaoSuperior;

public class OrgaoSuperiorDAO implements br.cic.unb.bd.integracao.OrgaoSuperiorDAO{

	public void salvar(OrgaoSuperior Osup) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(Osup.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(Osup);
		}
		else{
			//se ja tiver no bd, atualiza
			Osup = em.merge(Osup);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		OrgaoSuperior Osup = pesquisarPorID(id);
		if(Osup != null){
			em.remove(em.contains(Osup) ? Osup : em.merge(Osup));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();		
	}

	public OrgaoSuperior pesquisarPorID(int id) {
		String consulta = "FROM OrgaoSuperior as Osup where Osup.orgID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<OrgaoSuperior> osup = em.createQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (osup == null || osup.size()==0){
			return null;
		}
		return osup.get(0);
	}

	public List<OrgaoSuperior> pesquisarPorNome(String s) {
		
		
		EntityManager em = HibernateUtil.instance().em();
		Query consulta = em.createQuery("SELECT Osup FROM OrgaoSuperior as Osup WHERE Osup.name = :pmtNome");
		List<OrgaoSuperior> osups = consulta.setParameter("pmtNome", s).getResultList();
		
		if (osups == null || osups.size()==0){
			return null;
		}
		return osups;
	}

}
