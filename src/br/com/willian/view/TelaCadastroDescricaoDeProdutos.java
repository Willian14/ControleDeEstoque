/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.view;

import br.com.willian.Dao.CategoriaDao;
import br.com.willian.Dao.CorDao;
import br.com.willian.Dao.MarcaDao;
import br.com.willian.Dao.ModeloDao;
import br.com.willian.controller.ModeloTabela;
import br.com.willian.entity.Categoria;
import br.com.willian.entity.Cor;
import br.com.willian.entity.Marca;
import br.com.willian.entity.Modelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Willian
 */
public class TelaCadastroDescricaoDeProdutos extends javax.swing.JFrame {
    CategoriaDao cDao = new CategoriaDao();
    MarcaDao mDao = new MarcaDao();
    ModeloDao modDao = new ModeloDao();
    CorDao corDao = new CorDao();
   
    
    
    /**
     * Creates new form TelaCadastroDescricaoDeProdutos
     */
    public TelaCadastroDescricaoDeProdutos() {
        initComponents();
        txtId.setVisible(false);
        preencherTabelaCategoria();
        preencherTabelaMarca();
        preencherTabelaModelo();
        preencherTabelaCores();
        setDefaultCloseOperation(TelaCadastroDescricaoDeProdutos.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupBtn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdCategoria = new javax.swing.JRadioButton();
        rdMarca = new javax.swing.JRadioButton();
        rdCor = new javax.swing.JRadioButton();
        rdModelo = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbModelo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbCor = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbMarca = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbCategoria = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de características de produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Selecione uma opção: ");

        groupBtn.add(rdCategoria);
        rdCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdCategoria.setText("Categoria");

        groupBtn.add(rdMarca);
        rdMarca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdMarca.setText("Marca");

        groupBtn.add(rdCor);
        rdCor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdCor.setText("Cor");

        groupBtn.add(rdModelo);
        rdModelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdModelo.setText("Modelo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdCor)
                    .addComponent(rdMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdCategoria)
                    .addComponent(rdModelo))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdMarca)
                    .addComponent(rdModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCategoria)
                    .addComponent(rdCor))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addComponent(jLabel2))
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jtbModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbModeloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbModelo);

        jtbCor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbCor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbCor);

        jtbMarca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMarcaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbMarca);

        jtbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCategoriaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbCategoria);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 51, 0));
        jLabel3.setText("Modelos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Cores");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Marcas");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Categorias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel3)
                .addGap(218, 218, 218)
                .addComponent(jLabel4)
                .addGap(210, 210, 210)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
          Boolean validacao = validaCampos();
          //String acao = null;
          
         
          if(validacao == true){
                    if(rdCategoria.isSelected() == true){
                              Categoria categoria = new Categoria();
                              categoria.setNome(txtNome.getText().toUpperCase());
                              if(!(txtId.getText().equals(""))){
                                       categoria.setCod_categoria(Integer.parseInt(txtId.getText()));
                             }
                              cDao.salvar(categoria);
                              limparCampos();
                              preencherTabelaCategoria();
                              
                    }else if(rdCor.isSelected() == true){
                              Cor cor = new Cor();
                              cor.setNome(txtNome.getText().toUpperCase());
                             if(!(txtId.getText().equals(""))){
                                       cor.setCod_cor(Integer.parseInt(txtId.getText()));
                             }
                             corDao.salvar(cor);
                             limparCampos();
                             preencherTabelaCores();
                             
                    }else if(rdModelo.isSelected() == true){
                             Modelo mod = new Modelo();
                             mod.setNome(txtNome.getText().toUpperCase());
                             if(!(txtId.getText().equals(""))){
                                       mod.setCod_modelo(Integer.parseInt(txtId.getText()));
                             }
                             modDao.salvar(mod);
                             limparCampos();
                             preencherTabelaModelo();
                                                        
                    }else if(rdMarca.isSelected() == true){
                              Marca marca = new Marca();
                              marca.setNome(txtNome.getText().toUpperCase());
                              if(!(txtId.getText().equals(""))){
                                       marca.setCodMarca(Integer.parseInt(txtId.getText()));
                              }
                             mDao.salvar(marca);
                             limparCampos();
                             preencherTabelaMarca();
                    }
                    groupBtn.clearSelection();
          }
          
    }//GEN-LAST:event_btnSalvarActionPerformed

  
  
    private void jtbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCategoriaMouseClicked
          if(jtbCategoria.getSelectedRow() != -1){
                    jtbCor.getSelectionModel().clearSelection();
                    jtbMarca.getSelectionModel().clearSelection();
                    jtbModelo.getSelectionModel().clearSelection();
          }
    }//GEN-LAST:event_jtbCategoriaMouseClicked

    private void jtbMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMarcaMouseClicked
          if(jtbMarca.getSelectedRow() != -1){
                    jtbCor.getSelectionModel().clearSelection();
                    jtbCategoria.getSelectionModel().clearSelection();
                    jtbModelo.getSelectionModel().clearSelection();
          }
    }//GEN-LAST:event_jtbMarcaMouseClicked

    private void jtbCorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCorMouseClicked
          if(jtbCor.getSelectedRow() != -1){
                    jtbMarca.getSelectionModel().clearSelection();
                    jtbCategoria.getSelectionModel().clearSelection();
                    jtbModelo.getSelectionModel().clearSelection();
          }
    }//GEN-LAST:event_jtbCorMouseClicked

    private void jtbModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbModeloMouseClicked
          if(jtbModelo.getSelectedRow() != -1){
                    jtbMarca.getSelectionModel().clearSelection();
                    jtbCategoria.getSelectionModel().clearSelection();
                    jtbCor.getSelectionModel().clearSelection();
          }
    }//GEN-LAST:event_jtbModeloMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          
          if((jtbCategoria.getSelectedRow() != -1) || (jtbCor.getSelectedRow() != -1) 
                   || (jtbMarca.getSelectedRow() != -1) || (jtbModelo.getSelectedRow() != -1)){
                    carregarDadosParaTela();
          }else{
                    JOptionPane.showMessageDialog(null,"Selecione a linha de uma das tabelas a baixo que contém" + 
                               " a descrição que você deseja editar !");
          }  
         
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
          TelaCadastroProdutos tela1 = new TelaCadastroProdutos();
          tela1.setVisible(true);
          tela1.setResizable(false);
         this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaCadastroDescricaoDeProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDescricaoDeProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDescricaoDeProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroDescricaoDeProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroDescricaoDeProdutos().setVisible(true);
            }
        });
    }
    
    
    public void preencherTabelaCategoria(){
        
          ArrayList linhas =  cDao.buscarTodosParaTabela();
          String[] colunas = {"Código","Nome"};
          ModeloTabela mod = new ModeloTabela(linhas, colunas);
          
          if(linhas != null){
              
                    jtbCategoria.setModel(mod);
                    
                    jtbCategoria.getColumnModel().getColumn(0).setResizable(false);
                    jtbCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
                    jtbCategoria.getColumnModel().getColumn(1).setResizable(false);
                    jtbCategoria.getColumnModel().getColumn(1).setPreferredWidth(268);
                    
                    jtbCategoria.getTableHeader().setReorderingAllowed(false);
                    jtbCategoria.setAutoResizeMode(0);
                    jtbCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          }
    }
    
    public void preencherTabelaMarca(){
        
          ArrayList linhas = mDao.buscarTodosParaTabela();
          String[] colunas = {"Código","Nome"};
          ModeloTabela mod = new ModeloTabela(linhas, colunas);
                
          if(linhas != null){
              
                    jtbMarca.setModel(mod);

                    jtbMarca.getColumnModel().getColumn(0).setResizable(false);
                    jtbMarca.getColumnModel().getColumn(0).setPreferredWidth(50);
                    jtbMarca.getColumnModel().getColumn(1).setResizable(false);
                    jtbMarca.getColumnModel().getColumn(1).setPreferredWidth(175);

                    jtbMarca.getTableHeader().setReorderingAllowed(false);
                    jtbMarca.setAutoResizeMode(0);
                    jtbMarca.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          }
    }
    
    public void preencherTabelaModelo(){
        
          ArrayList linhas = modDao.buscarTodosParaTabela();
          String[] colunas = {"Código","Nome"};
          ModeloTabela mod = new ModeloTabela(linhas, colunas);
                
          if(linhas != null){
              
                    jtbModelo.setModel(mod);

                    jtbModelo.getColumnModel().getColumn(0).setResizable(false);
                    jtbModelo.getColumnModel().getColumn(0).setPreferredWidth(50);
                    jtbModelo.getColumnModel().getColumn(1).setResizable(false);
                    jtbModelo.getColumnModel().getColumn(1).setPreferredWidth(175);

                    jtbModelo.getTableHeader().setReorderingAllowed(false);
                    jtbModelo.setAutoResizeMode(0);
                    jtbModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          }
    }
    
    public void preencherTabelaCores(){
        
         ArrayList linhas = corDao.buscarTodosParaTabela();
          String[] colunas = {"Código","Nome"};
          ModeloTabela mod = new ModeloTabela(linhas, colunas);
                
          if(linhas != null){
              
                    jtbCor.setModel(mod);

                    jtbCor.getColumnModel().getColumn(0).setResizable(false);
                    jtbCor.getColumnModel().getColumn(0).setPreferredWidth(50);
                    jtbCor.getColumnModel().getColumn(1).setResizable(false);
                    jtbCor.getColumnModel().getColumn(1).setPreferredWidth(175);

                    jtbCor.getTableHeader().setReorderingAllowed(false);
                    jtbCor.setAutoResizeMode(0);
                    jtbCor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          }
    }
    
    public Boolean validaCampos(){
        
          Boolean valida = true;
          
          if(txtNome.getText().isEmpty()){
              
                    JOptionPane.showMessageDialog(null, "O campo nome está em branco! \n" + 
                             "Favor preencha o campo para prosseguir.");
                    valida = false;
                     txtNome.requestFocus();
                    return valida;
          }else if(rdCategoria.isSelected() == false && rdCor.isSelected() == false 
                    && rdMarca.isSelected() == false && rdModelo.isSelected() == false){
                    JOptionPane.showMessageDialog(null, "Escolha uma opção para prosseguir!");
                    valida = false;
                    rdMarca.requestFocus();
                    return valida;
          }
          return valida;
    }
    
    public void carregarDadosParaTela(){
          if(jtbCategoria.getSelectedRow() != -1){
                    txtNome.setText(jtbCategoria.getValueAt(jtbCategoria.getSelectedRow(), 1).toString());
                    txtId.setText(jtbCategoria.getValueAt(jtbCategoria.getSelectedRow(),0).toString());
                    
          }else if(jtbCor.getSelectedRow() != -1){
                    txtNome.setText(jtbCor.getValueAt(jtbCor.getSelectedRow(), 1).toString());
                    txtId.setText(jtbCor.getValueAt(jtbCor.getSelectedRow(), 0).toString());
          }else if(jtbModelo.getSelectedRow() != -1){
                    txtNome.setText(jtbModelo.getValueAt(jtbModelo.getSelectedRow(),1).toString());
                    txtId.setText(jtbModelo.getValueAt(jtbModelo.getSelectedRow(),0).toString());
          }else if(jtbMarca.getSelectedRow() != -1){
                    txtNome.setText(jtbMarca.getValueAt(jtbMarca.getSelectedRow(), 1).toString());
                    txtId.setText(jtbMarca.getValueAt(jtbMarca.getSelectedRow(),0).toString());
          }
    }
    
    public void limparCampos(){
          txtId.setText("");
          txtNome.setText("");
    }
   
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup groupBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtbCategoria;
    private javax.swing.JTable jtbCor;
    private javax.swing.JTable jtbMarca;
    private javax.swing.JTable jtbModelo;
    private javax.swing.JRadioButton rdCategoria;
    private javax.swing.JRadioButton rdCor;
    private javax.swing.JRadioButton rdMarca;
    private javax.swing.JRadioButton rdModelo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
