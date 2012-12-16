/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Revenda {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private int fone;
    private long CNPJ;
    private int ativo;

    public Revenda() {
    }

    public Revenda(int id, String nome, String email, int fone, long CNPJ, int ativo, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.fone = fone;
        this.CNPJ = CNPJ;
        this.ativo = ativo;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
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

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getFone() {
        return fone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public long getCNPJ() {
        return CNPJ;
    }
/*  Arrumar o override mais na frente:
    @Override
    public String toString() {
        return ;
    }
  */     
}