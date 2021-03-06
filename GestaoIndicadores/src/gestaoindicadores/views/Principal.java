/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.views;

import com.mysql.jdbc.Connection;
import gestaoindicadores.controlers.Usuarios;
import gestaoindicadores.models.CRUD;
import gestaoindicadores.models.Config;
import gestaoindicadores.models.PDF;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lucas
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Principal() {
        initComponents();
        
        this.setBackground(Color.white);
        //this.setExtendedState(MAXIMIZED_BOTH);
        
        if(Config.privilegio==0){
            this.MenuStake.setEnabled(false);
            this.menuCategoria.setEnabled(false);
            this.menuFuncoes.setEnabled(false);
            this.menuStatus.setEnabled(false);
        }
        
        this.jDesktopPane.setBackground(Color.GRAY);
        
        this.pendencia();
     

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        MenuStake = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenuItem();
        menuFuncoes = new javax.swing.JMenuItem();
        menuStatus = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuStake = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão de Indicadores");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        jMenu3.setText("Cadastros");

        MenuStake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/stakeholders_48X48.png"))); // NOI18N
        MenuStake.setText("Stakeholders");
        MenuStake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuStakeActionPerformed(evt);
            }
        });
        jMenu3.add(MenuStake);

        menuCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/categorias_48X48.png"))); // NOI18N
        menuCategoria.setText("Categorias");
        menuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCategoriaActionPerformed(evt);
            }
        });
        jMenu3.add(menuCategoria);

        menuFuncoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/funcoes_48X48.png"))); // NOI18N
        menuFuncoes.setText("Funções");
        menuFuncoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncoesActionPerformed(evt);
            }
        });
        jMenu3.add(menuFuncoes);

        menuStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/flag_48x48.png"))); // NOI18N
        menuStatus.setText("Status");
        menuStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStatusActionPerformed(evt);
            }
        });
        jMenu3.add(menuStatus);
        jMenu3.add(jSeparator1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/indicadores_48X48.png"))); // NOI18N
        jMenuItem5.setText("Ações");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar2.add(jMenu3);

        jMenu6.setText("Exportar");

        menuStake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/graph_20x20.png"))); // NOI18N
        menuStake.setText("Salvar em PDF pendentes");
        menuStake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStakeActionPerformed(evt);
            }
        });
        jMenu6.add(menuStake);

        jMenuBar2.add(jMenu6);

        jMenu4.setText("Sistema");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/40X56_close.png"))); // NOI18N
        jMenuItem6.setText("Logoff");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(754, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void alteraDesktop(Component x){
        this.jDesktopPane.removeAll();
        this.jDesktopPane.add(x);
        x.setSize(this.jDesktopPane.getWidth(), this.jDesktopPane.getHeight());
        x.setVisible(true);
        this.jDesktopPane.repaint();
        
        this.jDesktopPane.updateUI();
        
    }
    
    
    public void pendencia(){
        String sql = "select oque from acoes where quando <= CONCAT(CURRENT_DATE,'') and status <> 1 and quem = "+Config.usuario_logado;
        ResultSet x = new CRUD().select(sql);
        String retorno = "";
        try {
            while (x.next()) {
                retorno+="\n"+x.getString("oque");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas na alimentação das tabelas" + ex.getMessage());
        }
        if(!retorno.equals("")){
            JOptionPane.showMessageDialog(null,"Voce tem açoes vencidas em aberto\n"+retorno);
        }
    }
    
    private void MenuStakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuStakeActionPerformed
        // TODO add your handling code here:
        alteraDesktop(new Stakeholders());
    }//GEN-LAST:event_MenuStakeActionPerformed

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        // TODO add your handling code here:
        alteraDesktop(new Categorias());
        
    }//GEN-LAST:event_menuCategoriaActionPerformed

    private void menuFuncoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncoesActionPerformed
        // TODO add your handling code here:
        alteraDesktop(new Funcoes());
    }//GEN-LAST:event_menuFuncoesActionPerformed

    private void menuStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStatusActionPerformed
        alteraDesktop(new Status());
    }//GEN-LAST:event_menuStatusActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        alteraDesktop(new Acoes());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void menuStakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStakeActionPerformed
        // TODO add your handling code here:
        JFileChooser local = new JFileChooser();
        //local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        local.setDialogTitle("Escolha um local para salvar");
        local.setFileHidingEnabled(false);
        int res = local.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            String caminho = String.valueOf(local.getSelectedFile());
            try {
                String arquivo = "";
                
                String sql = "select oque,porque,quando,como from acoes where quando <= CONCAT(CURRENT_DATE,'') and status <> 1 and quem = "+Config.usuario_logado;
                ResultSet x = new CRUD().select(sql);
                while(x.next()){
                    arquivo+="O que? "+x.getString("oque")+"  \n Porque:  "+x.getString("porque")+"   \n Quando:  "+x.getString("quando")+" \n Como: "+x.getString("como")+"\n\n\n----------------------------------------------------\n";
                }
                
                
                 PDF.exportarPDF(caminho + ".pdf", "Relatorio", arquivo);
                 
                 JOptionPane.showMessageDialog(null, "PDF criado com sucesso");
              
                 
                 
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Erro em criar o arquivo PDF: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                 System.out.println("Erro em criar o arquivo PDF: " + ex.getMessage());
             }
        }

    }//GEN-LAST:event_menuStakeActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuStake;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuFuncoes;
    private javax.swing.JMenuItem menuStake;
    private javax.swing.JMenuItem menuStatus;
    // End of variables declaration//GEN-END:variables
}
