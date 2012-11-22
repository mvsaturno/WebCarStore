/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Saturno
 */
public class Anuncio {
    private int id;
    private Veiculo veiculo;
    private String data_inicio;

    public Anuncio() {
    }

    public Anuncio(Veiculo veiculo, String data_inicio) {
        this.veiculo = veiculo;
        this.data_inicio = data_inicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return super.toString();
        //Sobrescrever toString depois;
    }
    
    
}
