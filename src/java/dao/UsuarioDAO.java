/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Usuario;
import util.PropertiesManager;

/**
 *
 * @author Saturno
 */
public class UsuarioDAO implements InterfaceDAO{
    private HashMap dados;

    public UsuarioDAO() throws IOException {
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }

    @Override
    public void inserir(Object obj) throws SQLException {
        Usuario user = (Usuario) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Usuario");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, user.getNome());
        stmt.setString(2, user.getLogin());
        stmt.setString(3, user.getSenha());
        stmt.setString(4, user.getData_nasc());
        stmt.execute();
        conexao.close();
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList userList = new ArrayList();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setLogin(rs.getString(3));
            usuario.setSenha(rs.getString(4));
            usuario.setData_nasc(rs.getString(5));
            userList.add(usuario);
        }
        pstmt.close();
        return userList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Usuario pesquisarLogin(String login) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Usuario usuario = null;
        String sql = (String) dados.get("SelectByLogin.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, login);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
        }
        pstmt.close();
        return usuario;
    }
}
