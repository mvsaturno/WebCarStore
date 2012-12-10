/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private int permissao; //Testaremos a permissão pelo número: 1-administrador, 2-gerente, 3-vendedor, 4-cliente.
    private String data_nasc;
    private Revenda revenda;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, int permissao, String data_nasc, Revenda revenda) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
        this.data_nasc = data_nasc;
        this.revenda = revenda;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getPermissao() {
        return permissao;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public Revenda getRevenda() {
        return revenda;
    }

    public String getSenha() {
        return senha;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }

    public void setRevenda(Revenda revenda) {
        this.revenda = revenda;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return ("Id = " + id + "\nNome = " + nome + "\n Login = " + login + "\n Senha = " + senha);
        /*Alterar de acordo com a implementação do HTML*/
    }
    
    
    
}