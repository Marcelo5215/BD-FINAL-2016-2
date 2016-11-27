package br.cic.unb.bd.GUI;
import br.cic.unb.bd.estrutura.*;
import br.cic.unb.bd.integracao.jpa.*;

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
    {
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
        
    }
}
