/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.willian.entity;

/**
 *
 * @author Willian
 */
public class Marca {
    private Integer cod_marca;
    private String nome;

    public Marca() {
    }

    public Marca(Integer cod_marca, String nome) {
          this.cod_marca = cod_marca;
          this.nome = nome;
    }
    
    
    public void setCodMarca(Integer cod_marca){
          this.cod_marca = cod_marca;
    }
    
    public Integer getCodMarca(){
          return cod_marca;
    }
    
    public void setNome(String nome){
          this.nome = nome;
    }
    
    public String getNome(){
          return nome;
    }
}
