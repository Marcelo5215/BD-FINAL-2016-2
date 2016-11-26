package br.cic.unb.bd.integracao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.cic.unb.bd.estrutura.Pagamento;;

public class PagamentoDAO implements br.cic.unb.bd.integracao.PagamentoDAO{

	public void salvar(Pagamento pag) {
		EntityManager em = HibernateUtil.instance().em();
		//permite comecar a transacao para o bd
		em.getTransaction().begin();
		
		if (pesquisarPorID(pag.getID()) == null){
			//se nao tiver no bd, cria
			em.persist(pag);
		}
		else{
			//se ja tiver no bd, atualiza
			pag = em.merge(pag);
		}
		em.flush();
		//finaliza transacao
		em.getTransaction().commit();
		em.close();
	}

	public void excluir(int id) {
		EntityManager em = HibernateUtil.instance().em();
		
		em.getTransaction().begin();
		Pagamento pagamento = pesquisarPorID(id);
		if(pagamento != null){
			em.remove(em.contains(pagamento) ? pagamento : em.merge(pagamento));
			em.flush();
			em.getTransaction().commit();
		}
		em.close();
	}

	public Pagamento pesquisarPorID(int id) {
		String consulta = "SELECT * FROM PAGAMENTO pag WHERE pag.docpagID = :pmtID";
		
		EntityManager em = HibernateUtil.instance().em();
		
		List<Pagamento> pag = em.createNamedQuery(consulta).setParameter("pmtID", id).getResultList();
		
		if (pag == null || pag.size()==0){
			return null;
		}
		return pag.get(0);
	}

	public List<Pagamento> pesquisarPorNome(String s) {
		String consulta = "SELECT * FROM PAGAMENTO pag WHERE pag.nome = :pmtNome";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pagamento> pag = em.createNamedQuery(consulta).setParameter("pmtNome", s).getResultList();
		
		if (pag == null || pag.size()==0){
			return null;
		}
		return pag;
	}

	public List<Pagamento> pesquisarPorValor(double valor) {
		String consulta = "SELECT * FROM PAGAMENTO pag WHERE pag.Valor = :pmtValor";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pagamento> pag = em.createNamedQuery(consulta).setParameter("pmtValor", valor).getResultList();
		
		if (pag == null || pag.size()==0){
			return null;
		}
		return pag;
	}

	public List<Pagamento> pesquisarPorData(Date data) {
		String consulta = "SELECT * FROM PAGAMENTO pag WHERE pag.Data_pagamento = :pmtData";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pagamento> pag = em.createNamedQuery(consulta).setParameter("pmtData", data).getResultList();
		
		if (pag == null || pag.size()==0){
			return null;
		}
		return pag;
	}

	public List<Pagamento> pesquisarPorPessoa(int cpf) {
		String consulta = "SELECT * FROM PAGAMENTO pag WHERE pag.CPF_PESSOA = :pmtCPF";
		
		EntityManager em = HibernateUtil.instance().em();
		List<Pagamento> pag = em.createNamedQuery(consulta).setParameter("pmtCPF", cpf).getResultList();
		
		if (pag == null || pag.size()==0){
			return null;
		}
		return pag;
	}

}
