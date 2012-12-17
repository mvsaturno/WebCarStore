/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio-CS
 */
public class Administrador extends Usuario {

    public Administrador(Usuario user) {

        super(user.getId(), user.getNome(), user.getLogin(), user.getSenha(), user.getPermissao(), user.getRevenda(), user.getAtivo(), user.getCelular(), user.getTelefone());

    }

    public String cadastrarUsuario(Usuario user) throws IOException, SQLException {
        String msg = "";
        UsuarioDAO admin = new UsuarioDAO();
        try {
            if (admin.inserir(user)) {
                msg = "Inserido com sucesso!";
            } else {
                msg = "Erro na inserção do usuário! ";
            }
        } catch (Exception e) {
            msg += e.getMessage();
        }
        return msg;
    }

    public String deletarUsuario(int id) throws IOException {
        String msg = "";
        UsuarioDAO admin = new UsuarioDAO();
        try {
            if (admin.excluir(id)) {
                msg = "Excluído com sucesso!";
            } else {
                msg = "Erro na exclusão do usuário! ";
            }
        } catch (Exception e) {
            msg += e.getMessage();
        }
        return msg;

    }
    
    public ArrayList listarUsuarios() throws IOException, SQLException {
        UsuarioDAO admin = new UsuarioDAO();
        ArrayList result = null;
            result = admin.pesquisarTudo();
                return result;
    }
}
