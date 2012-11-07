/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Saturno
 */
public class Revenda {
    private int id;
    private String nome;
    private String email;
    private String setor;
    private String endereco;
    private String fone;
    private String CNPJ;
    private java.sql.Date data_cadastro;

    public Revenda() {
    }

    public Revenda(int id, String nome, String email, String setor, String endereco, String fone, String CNPJ, Date data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
        this.endereco = endereco;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.data_cadastro = data_cadastro;
    }
    
    public Revenda(String nome, String email, String setor, String endereco, 
            String fone, String CNPJ, Date data_cadastro) {
        this.nome = nome;
        this.email = email;
        this.setor = setor;
        this.endereco = endereco;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.data_cadastro = data_cadastro;
    }
    
    public void setRevenda (Revenda rev){
        this.setId(rev.getId());
        this.setNome(rev.getNome());
        this.setEmail(rev.getEmail());
        this.setSetor(rev.getSetor());
        this.setCNPJ(rev.getCNPJ());
        this.setEndereco(rev.getEndereco());
        this.setFone(rev.getFone());
        this.setData_cadastro(rev.getData_cadastro());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getSetor() {
        return setor;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getFone() {
        return fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public String getCNPJ() {
        return CNPJ;
    }
/*  Arrumar o override mais na frente:
    @Override
    public String toString() {
        return ;
    }
  */     
}