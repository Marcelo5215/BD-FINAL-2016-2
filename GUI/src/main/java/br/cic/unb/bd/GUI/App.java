package br.cic.unb.bd.GUI;
import br.cic.unb.bd.estrutura.*;
import br.cic.unb.bd.integracao.jpa.*;
import br.cic.unb.bd.integracao.jpa.queries.PessoaPagamento;
import br.cic.unb.bd.integracao.jpa.queries.PessoaValorTotal;
import br.cic.unb.bd.integracao.jpa.queries.PessoaViagemTotal;
import br.cic.unb.bd.integracao.jpa.queries.Queries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.List.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	/*
        OrgaoSuperior OS = new OrgaoSuperior();
        OrgaoSuperiorDAO OSDAO = new OrgaoSuperiorDAO();
        //LinkedList<OrgaoSuperior> L = new LinkedList<OrgaoSuperior>();
        
        List<OrgaoSuperior> orgs = new ArrayList<OrgaoSuperior>();
        orgs = OSDAO.pesquisarPorNome("PRESIDENCIA DA REPUBLICA");
        
        System.out.println(orgs.get(0).getID());
        
        Pagamento pag = new Pagamento();
        PagamentoDAO pagDAO = new PagamentoDAO();
        List<Pagamento> pags = new ArrayList<Pagamento>();
        pag = pagDAO.pesquisarPorID(0);
        
        System.out.println(pag.getData());
        */
    	
        Queries queries = new Queries();
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaD = new PessoaDAO();
        
        List<Pessoa> pess = new ArrayList<Pessoa>();
        pessoa = pessoaD.pesquisarPorCPF(67418);
        
        System.out.println(pessoa.getName());
        
        /*
        double res = queries.quantoPessoaGastou(69258);
        
        System.out.println(res);
        
        res = queries.quantoOrgaoSuperiorGastou("PRESIDENCIA DA REPUBLICA");
        System.out.println(res);*/
        
       /* List<PessoaValorTotal> listaDados = queries.quantoTodasPessoasGastaram();
        
        for(PessoaValorTotal dado : listaDados){
        	System.out.println(dado.getNome());
        	System.out.println(dado.getValor());
        }*/
        
        /*
        List<PessoaViagemTotal> listaDados = queries.quantoTodasPessoasViajaram();
        
        for(PessoaViagemTotal dado : listaDados){
        	System.out.println(dado.getNome());
        	System.out.println(dado.getViagens());
        }*/
        
        List<PessoaPagamento> listaFinal = queries.quantoPessoaMaisGastou();
        for(PessoaPagamento dado : listaFinal){
        	System.out.println(dado.getPessoaNome());
        	System.out.println(dado.getData());
        	System.out.println(dado.getValor());
        }
    }
}
