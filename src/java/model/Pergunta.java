/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author saturno
 */
public class Pergunta {
    int id_pergunta, id_resposta;
    String pergunta;
    Usuario cliente;

    public Pergunta() {
    }

    public Pergunta(int id_pergunta, int id_resposta, String pergunta, Usuario cliente) {
        this.id_pergunta = id_pergunta;
        this.id_resposta = id_resposta;
        this.pergunta = pergunta;
        this.cliente = cliente;
    }
    
    public Pergunta(int id_resposta, String pergunta, Usuario cliente) {
        this.id_resposta = id_resposta;
        this.pergunta = pergunta;
        this.cliente = cliente;
        
    }
    
    public Usuario getCliente() {
        return cliente;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

}
