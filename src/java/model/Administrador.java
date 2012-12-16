/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fabio-CS
 */
public class Administrador extends Usuario{
    
    public Administrador(Usuario user){
    
    super(user.getId(), user.getNome(), user.getLogin(), user.getSenha(), user.getPermissao(), user.getRevenda(), user.getAtivo(), user.getCelular(), user.getTelefone());
    
    }
    
    public Revenda cadastrarRevenda(){
        
        Revenda revenda = new Revenda();
        return revenda;
    }
    
    
}
