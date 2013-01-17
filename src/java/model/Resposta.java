/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author saturno
 */
public class Resposta {
    int id_resposta;
    int id_pergunta;
    String resposta;
    Usuario cliente, vendedor;

    public Resposta() {
    }

    public Resposta(int id_resposta, int id_pergunta, String resposta, Usuario cliente, Usuario vendedor) {
        this.id_resposta = id_resposta;
        this.id_pergunta = id_pergunta;
        this.resposta = resposta;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }
    
    public Resposta(int id_pergunta, String resposta, Usuario cliente, Usuario vendedor) {
        this.id_pergunta = id_pergunta;
        this.resposta = resposta;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public String getPergunta() {
        return resposta;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    public void setPergunta(String resposta) {
        this.resposta = resposta;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

}
