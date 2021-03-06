/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cic.unb.bd.GUI;
import javax.swing.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
 *
 * @author macel
 */
@SuppressWarnings("unused")
public class GraphicInterface extends JFrame {
	
	private Queries queries = new Queries();
    /**
	 * 
	 */
	private static final long serialVersionUID = -2037495145957961599L;

    public GraphicInterface() {
        initComponents();
    }



    private void initComponents() {

        WarningFrame = new JFrame();
        WarningInternalFrame = new JInternalFrame();
        WarnButton = new JButton();
        WarnText = new JLabel();
        InternalFrame = new JInternalFrame();
        ScrollPane = new JScrollPane();
        Table = new JTable();
        Menu = new JMenuBar();
        QueryMenu = new JMenu();
        Query1 = new JMenuItem();
        Query2 = new JMenuItem();
        Query3 = new JMenuItem();
        Query4 = new JMenuItem();
        Query5 = new JMenuItem();

        WarningInternalFrame.setVisible(true);

        WarnButton.setText("OK");
        WarnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                OKWarnActionPerformed(evt);
            }
        });

        WarnText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        WarnText.setText("jLabel1");

        GroupLayout WarningInternalFrameLayout = new GroupLayout(WarningInternalFrame.getContentPane());
        WarningInternalFrame.getContentPane().setLayout(WarningInternalFrameLayout);
        WarningInternalFrameLayout.setHorizontalGroup(
            WarningInternalFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, WarningInternalFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(WarnButton))
            .addGroup(WarningInternalFrameLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(WarnText, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        WarningInternalFrameLayout.setVerticalGroup(
            WarningInternalFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, WarningInternalFrameLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(WarnText, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(WarnButton)
                .addContainerGap())
        );

        GroupLayout WarningFrameLayout = new GroupLayout(WarningFrame.getContentPane());
        WarningFrame.getContentPane().setLayout(WarningFrameLayout);
        WarningFrameLayout.setHorizontalGroup(
            WarningFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(WarningInternalFrame)
        );
        WarningFrameLayout.setVerticalGroup(
            WarningFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(WarningInternalFrame)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        InternalFrame.setVisible(true);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPane.setViewportView(Table);

        QueryMenu.setText("Querys");

        Query1.setText("Quanto uma pessoa gastou");
        Query1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        QueryMenu.add(Query1);

        Query2.setText("Quanto orgao superior gastou");
        Query2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        QueryMenu.add(Query2);

        Query3.setText("Quanto cada pessoa gastou");
        Query3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        QueryMenu.add(Query3);

        Query4.setText("Quanto as pessoas viajaram");
        Query4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        QueryMenu.add(Query4);

        Query5.setText("Viagens da pessoa que mais gastou");
        Query5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                QueryActionPerformed(evt);
            }
        });
        QueryMenu.add(Query5);

        Menu.add(QueryMenu);

        InternalFrame.setJMenuBar(Menu);

        GroupLayout InternalFrameLayout = new GroupLayout(InternalFrame.getContentPane());
        InternalFrame.getContentPane().setLayout(InternalFrameLayout);
        InternalFrameLayout.setHorizontalGroup(
            InternalFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(InternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );
        InternalFrameLayout.setVerticalGroup(
            InternalFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, InternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPane, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(InternalFrame)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(InternalFrame)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QueryActionPerformed(ActionEvent evt) {                                       
        if(evt.getSource().equals(Query1)){
        	String s = (String)JOptionPane.showInputDialog(
                    WarningFrame,
                    "Digite o CPF da pessoa, 5 numeros do meio desconsiderando zeros a esquerda.");
        	
        	Double res = queries.quantoPessoaGastou(Integer.parseInt(s));
        	String nome = queries.nomePessoa(Integer.parseInt(s));
        	String[] cols = {"Pessoa", "Gastos"};
            Object[][] data;
        	data = new Object[1][2];
        	if(nome == null){
                data[0][0] = new String("PESSOA NAO ENCONTRADA");
                data[0][1] = new Double(0.0);
        	}
        	else{
                data[0][0] = new String(nome);
                data[0][1] = new Double(res);
        	}
            
            Table.setModel(new javax.swing.table.DefaultTableModel(
            		data,
            		cols));
        }
        else if(evt.getSource().equals(Query2)){
        	
        	String s = (String)JOptionPane.showInputDialog(
                    WarningFrame,
                    "Digite o Nome do orgao Superior");
        	
        	Double res = queries.quantoOrgaoSuperiorGastou(s);
        	String[] cols = {"Orgao", "Gastos"};
            Object[][] data;
        	data = new Object[1][2];
        	if(res < 0){
                data[0][0] = new String("ORGAO NAO ENCONTRADO");
                data[0][1] = new Double(0.0);
        	}
        	else{
                data[0][0] = new String(s);
                data[0][1] = new Double(res);
        	}
            
            Table.setModel(new javax.swing.table.DefaultTableModel(
            		data,
            		cols));
    
        }
        else if(evt.getSource().equals(Query3)){
        	List<PessoaValorTotal> listaDados = queries.quantoTodasPessoasGastaram();
            
        	String[] cols = {"Nome", "Gastos"};
            Object[][] data;
            data = new Object[listaDados.size()][2];
            int i = 0;
            for(PessoaValorTotal dado : listaDados){
            	data[i][0] = new String(dado.getNome());
            	data[i][1] = new Integer((int) dado.getValor());
            	i++;
            }
            
            Table.setModel(new javax.swing.table.DefaultTableModel(
            		data,
            		cols));
        }
        else if(evt.getSource().equals(Query4)){
            List<PessoaViagemTotal> listaDados = queries.quantoTodasPessoasViajaram();
            
            String[] cols = {"Nome", "Viagens"};
            Object[][] data;
            data = new Object[listaDados.size()][2];
            int i = 0;
            for(PessoaViagemTotal dado : listaDados){
            	data[i][0] = new String(dado.getNome());
            	data[i][1] = new Long(dado.getViagens());
            	i++;
            }
            
            Table.setModel(new javax.swing.table.DefaultTableModel(
            		data,
            		cols));
        }
        else if(evt.getSource().equals(Query5)){
            List<PessoaPagamento> listaFinal = queries.quantoPessoaMaisGastou();
            
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String[] cols = {"Nome", "Nome Documento" ,"Data", "Valor"};
            Object[][] data;
            data = new Object[listaFinal.size()][4];
            int i = 0;
            for(PessoaPagamento dado : listaFinal){
        		data[i][0] = new String(dado.getPessoaNome());
        		data[i][1] = new String(dado.getPagamento().getName());
        		data[i][2] = new String(df.format(dado.getPagamento().getData()));
        		data[i][3] = new Double(dado.getPagamento().getValor());
            	i++;
            }
            
            Table.setModel(new javax.swing.table.DefaultTableModel(
            		data,
            		cols));

        }
    }                                                                    
    
    private void OKWarnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Query2ActionPerformed

    }//GEN-LAST:event_Query2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JInternalFrame InternalFrame;
    private JMenuBar Menu;
    private JMenuItem Query1;
    private JMenuItem Query2;
    private JMenuItem Query3;
    private JMenuItem Query4;
    private JMenuItem Query5;
    private JMenu QueryMenu;
    private JScrollPane ScrollPane;
    private JTable Table;
    private JButton WarnButton;
    private JLabel WarnText;
    private JFrame WarningFrame;
    private JInternalFrame WarningInternalFrame;
    // End of variables declaration//GEN-END:variables
}
