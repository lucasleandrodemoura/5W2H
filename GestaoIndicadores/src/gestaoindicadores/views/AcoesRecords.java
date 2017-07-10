/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaoindicadores.views;

import gestaoindicadores.controlers.Usuarios;
import gestaoindicadores.models.CRUD;
import gestaoindicadores.models.HibernateUtil;
import java.awt.Color;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lucas
 */
public class AcoesRecords extends javax.swing.JFrame {
    private int codigo = 0;
    
    public void seleciona(String codigo,String descricao,JTextField cod, JTextField desc){
        cod.setText(codigo);
        desc.setText(descricao);
    }
    
    /**
     * Creates new form StakeholdersRecords
     */
    public AcoesRecords() {
        initComponents();
        this.setBackground(Color.white);
        
        this.btnStakeholders.setVisible(false);
     
            this.setTitle("Acoes | Novo");
//            this.btnFechaAcao.setVisible(false);
            this.save.setText("Salvar");
  //          this.btnStakeholders.setVisible(false);
        
    }
    
    
    public AcoesRecords(int cod) {
        initComponents();
        this.setBackground(Color.white);
        this.codigo = cod;
        
        
        
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            
            org.hibernate.Query q = sessao.createQuery("FROM Acoes WHERE idacoes = "+cod);
            
            resultado = q.list();

            for (Object o : resultado) {
                gestaoindicadores.controlers.Acoes p = (gestaoindicadores.controlers.Acoes) o;
                this.idCategoria.setText(p.getCategoria()+"");
                this.descricaoCategoria.setText(p.getCategorias().getDescricao());
                this.idStatus.setText(p.getStatus()+"");
                this.descricaoStatus.setText(p.getStatusC().getDescricao());
                this.idResponsavel.setText(p.getQuem().getIdusuarios()+"");
                this.descricaoResponsavel.setText(p.getQuem().getNome());
                this.oque.setText(p.getOque());
                this.onde.setText(p.getOnde());
                String quando = p.getQuando();
                String[] quandoS = quando.split("-");
                this.quando.setText(quandoS[2]+"/"+quandoS[1]+"/"+quandoS[0]);
                this.porque.setText(p.getPorque());
                this.como.setText(p.getComo());
                
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        
        
         this.setTitle("Acoes | Editar");
//            this.btnFechaAcao.setVisible(true);
  //          this.btnStakeholders.setVisible(true);
            this.save.setText("Atualizar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idCategoria1 = new javax.swing.JTextField();
        descricaoCategoria1 = new javax.swing.JTextField();
        jButtonCategoria1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        idResponsavel1 = new javax.swing.JTextField();
        descricaoResponsavel1 = new javax.swing.JTextField();
        jButtonResponsavel1 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idCategoria = new javax.swing.JTextField();
        descricaoCategoria = new javax.swing.JTextField();
        jButtonCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idResponsavel = new javax.swing.JTextField();
        descricaoResponsavel = new javax.swing.JTextField();
        jButtonResponsavel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        oque = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        onde = new javax.swing.JTextField();
        quando = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        porque = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        como = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        idStatus = new javax.swing.JTextField();
        descricaoStatus = new javax.swing.JTextField();
        jButtonStatus = new javax.swing.JButton();
        btnStakeholders = new javax.swing.JButton();

        idCategoria1.setEditable(false);

        descricaoCategoria1.setEditable(false);

        jButtonCategoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/search_16X16.png"))); // NOI18N
        jButtonCategoria1.setToolTipText("Localizar");

        jLabel8.setText("Responsável: *");

        idResponsavel1.setEditable(false);

        descricaoResponsavel1.setEditable(false);

        jButtonResponsavel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/search_16X16.png"))); // NOI18N
        jButtonResponsavel1.setToolTipText("Localizar");
        jButtonResponsavel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResponsavel1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/save_48X48.png"))); // NOI18N
        save.setText("Salvar");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel1.setText("Categoria: *");

        idCategoria.setEditable(false);

        descricaoCategoria.setEditable(false);

        jButtonCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/search_16X16.png"))); // NOI18N
        jButtonCategoria.setToolTipText("Localizar");
        jButtonCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Responsável: *");

        idResponsavel.setEditable(false);

        descricaoResponsavel.setEditable(false);

        jButtonResponsavel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/search_16X16.png"))); // NOI18N
        jButtonResponsavel.setToolTipText("Localizar");
        jButtonResponsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResponsavelActionPerformed(evt);
            }
        });

        jLabel3.setText("O que? *");

        oque.setColumns(20);
        oque.setRows(5);
        jScrollPane1.setViewportView(oque);

        jLabel4.setText("Onde? *");

        quando.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel5.setText("Quando? *");

        jLabel6.setText("Porque? *");

        jLabel7.setText("Como? *");

        como.setColumns(20);
        como.setRows(5);
        jScrollPane2.setViewportView(como);

        jLabel9.setText("Status: *");

        idStatus.setEditable(false);

        descricaoStatus.setEditable(false);

        jButtonStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/search_16X16.png"))); // NOI18N
        jButtonStatus.setToolTipText("Localizar");
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });

        btnStakeholders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestaoindicadores/includes/48x48_users.png"))); // NOI18N
        btnStakeholders.setText("Stakeholders");
        btnStakeholders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStakeholdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(281, 281, 281))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(porque)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnStakeholders)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(onde, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(quando))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descricaoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonResponsavel))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descricaoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonStatus))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(32, 32, 32)
                                        .addComponent(idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(descricaoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCategoria)))))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(idCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descricaoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descricaoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descricaoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonStatus))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(btnStakeholders))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if(this.idCategoria.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo CATEGORIA é obrigatório");
        }
        else if(this.idResponsavel.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo RESPONSÁVEL é obrigatório");
        }
        else if(this.idStatus.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo STATUS é obrigatório");
        }
        else if(this.oque.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo O QUE é obrigatório");
        }
        else if(this.onde.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo ONDE é obrigatório");
        }
        else if(this.quando.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo QUANDO é obrigatório");
        }
        else if(this.porque.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo PORQUE é obrigatório");
        }
        else if(this.como.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo COMO é obrigatório");
        }
        else {
         Session sessao = null;
         
         
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            gestaoindicadores.controlers.Acoes obj = new gestaoindicadores.controlers.Acoes();
            obj.setAvisarEnvolvidos(false);
            obj.setCategoria(Integer.parseInt(this.idCategoria.getText()));
            obj.setCategorias(new gestaoindicadores.controlers.Categorias(Integer.parseInt(this.idCategoria.getText())));
            obj.setComo(this.como.getText());
            obj.setDataCadastro(new Date(System.currentTimeMillis()));
            obj.setDiasAntecedencia(0);
            obj.setFeedback("");
            obj.setOnde(this.onde.getText());
            obj.setOque(this.oque.getText());
            obj.setPorque(this.porque.getText());
            String q = this.quando.getText();
            String data[] = q.split("/");
            q = data[2]+"-"+data[1]+"-"+data[0];
            obj.setQuando(q);
            obj.setQuem(new Usuarios(Integer.parseInt(this.idResponsavel.getText())));
            obj.setStatus(Integer.parseInt(this.idStatus.getText()));
            
            if(this.codigo == 0){
                
                
                sessao.save(obj);
                
                
            }else{
                obj.setIdacoes(this.codigo);
                //Se o status for fechado
                if(obj.getStatus()==3){
                    String feedback = JOptionPane.showInputDialog(null, "Digite um feedback para esta ação");
                    obj.setFeedback(feedback);
                }
                sessao.update(obj);
            }
            t.commit();
            JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
            this.dispose();
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "ERRO: "+he.getMessage()+" "+he.getLocalizedMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
                
                }
        
        
    }//GEN-LAST:event_saveActionPerformed

    private void jButtonCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaActionPerformed
        // TODO add your handling code here:
        buscar x = new buscar();
        x.campo_codigo = "idcategorias";
        x.tabela = "categorias";
        x.campo_descricao = "descricao";
        x.tela_retorno = this;
        x.campo_codigo_j = this.idCategoria;
        x.campo_descricao_j = this.descricaoCategoria;
        x.AlimentaTabela();
        x.setVisible(true);
    }//GEN-LAST:event_jButtonCategoriaActionPerformed

    private void jButtonResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResponsavelActionPerformed
        // TODO add your handling code here:
         buscar x = new buscar();
        x.campo_codigo = "idusuarios";
        x.tabela = "usuarios";
        x.campo_descricao = "nome";
        x.tela_retorno = this;
        x.campo_codigo_j = this.idResponsavel;
        x.campo_descricao_j = this.descricaoResponsavel;
        x.AlimentaTabela();
        x.setVisible(true);
    }//GEN-LAST:event_jButtonResponsavelActionPerformed

    private void jButtonResponsavel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResponsavel1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonResponsavel1ActionPerformed

    private void jButtonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatusActionPerformed
        // TODO add your handling code here:
         buscar x = new buscar();
        x.campo_codigo = "idstatus";
        x.tabela = "status";
        x.campo_descricao = "descricao";
        x.tela_retorno = this;
        x.campo_codigo_j = this.idStatus;
        x.campo_descricao_j = this.descricaoStatus;
        x.AlimentaTabela();
        x.setVisible(true);
    }//GEN-LAST:event_jButtonStatusActionPerformed

    private void btnStakeholdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStakeholdersActionPerformed
        // TODO add your handling code here:
        StakeholdersAcoes stakeholdersAcoes = new StakeholdersAcoes(this.codigo);
        stakeholdersAcoes.setVisible(true);
    }//GEN-LAST:event_btnStakeholdersActionPerformed

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
            java.util.logging.Logger.getLogger(AcoesRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcoesRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcoesRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcoesRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcoesRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStakeholders;
    private javax.swing.JTextArea como;
    private javax.swing.JTextField descricaoCategoria;
    private javax.swing.JTextField descricaoCategoria1;
    private javax.swing.JTextField descricaoResponsavel;
    private javax.swing.JTextField descricaoResponsavel1;
    private javax.swing.JTextField descricaoStatus;
    private javax.swing.JTextField idCategoria;
    private javax.swing.JTextField idCategoria1;
    private javax.swing.JTextField idResponsavel;
    private javax.swing.JTextField idResponsavel1;
    private javax.swing.JTextField idStatus;
    private javax.swing.JButton jButtonCategoria;
    private javax.swing.JButton jButtonCategoria1;
    private javax.swing.JButton jButtonResponsavel;
    private javax.swing.JButton jButtonResponsavel1;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField onde;
    private javax.swing.JTextArea oque;
    private javax.swing.JTextField porque;
    private javax.swing.JFormattedTextField quando;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
