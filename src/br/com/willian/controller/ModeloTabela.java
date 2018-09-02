/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Willian
 */
public class ModeloTabela extends AbstractTableModel {
    private ArrayList linhas = null;
    private String [] colunas = null;
    
    public ModeloTabela(ArrayList linhas , String [] colunas){
          this.linhas = linhas;
          this.colunas = colunas;
    }
    
    public ModeloTabela(){
        
    }
    
    public void setLinhas(ArrayList linhas){
          this. linhas = linhas;
    }
    
    public ArrayList getLinhas(){
          return linhas;
    }
    
    public void setColunas(String [] colunas){
          this.colunas = colunas;
    }
    
    public String [] getColunas(){
          return colunas;
    }
    
    public int getColumnCount(){
          return colunas.length;
    }
    
    public int getRowCount(){
          return linhas.size();
    }
    
    public String getColumnName(int numCol){
          return colunas[numCol];
    }
    
    public Object getValueAt(int numLin,int numCol){
          Object [] linha = (Object[]) getLinhas().get(numLin);
          return linha[numCol];
    }
}
