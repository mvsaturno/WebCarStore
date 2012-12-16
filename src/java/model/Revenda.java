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
    private String endereco;
    private String fone;
    private String CNPJ;
    private String login;
    private String senha;
    private int ativo;
    private java.sql.Date data_cadastro;

    public Revenda() {
    }

    public Revenda(int id, String nome, String email, String endereco, String fone, String CNPJ, String login, String senha, int ativo, Date data_cadastro) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.data_cadastro = data_cadastro;
    }

    public int getAtivo() {
        return ativo;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
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