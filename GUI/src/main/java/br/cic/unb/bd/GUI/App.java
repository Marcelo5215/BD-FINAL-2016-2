package br.cic.unb.bd.GUI;
import br.cic.unb.bd.estrutura.*;
import br.cic.unb.bd.integracao.jpa.*;

import java.util.LinkedList;
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
        
        
        OS = OSDAO.pesquisarPorID(20000);
        
        System.out.println(OS.getName());
    }
}
