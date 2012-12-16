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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Administrador;
import model.Cliente;
import model.Gerente;
import model.Revenda;
import model.Usuario;
import model.Vendedor;
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
   
        stmt.setString(1, user.getLogin());
        stmt.setInt(2, user.getPermissao());
        stmt.setString(3, user.getNome());
        stmt.setString(4, user.getSenha());     
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
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPermissao(rs.getInt("tipo_usuario"));
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
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setLogin(rs.getString("email"));
            usuario.setPermissao(rs.getInt("id_tipo_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getInt("ativo"));
            usuario.setCelular(rs.getInt("celular"));
            usuario.setTelefone(rs.getInt("telefone"));
            
                int rev = rs.getInt("id_revenda");
                Revenda revenda = null;
            try {
                revenda = (Revenda) new RevendaDAO().pesquisarChave(rev);
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            usuario.setRevenda(revenda);
            
            int permissao = usuario.getPermissao();
            switch(permissao){
                case 1:
                    usuario = new Administrador(usuario);        
                    break;
                case 2:
                    usuario = new Gerente(usuario);
                    break;
                case 3:
                    usuario = new Vendedor(usuario);
                    break;
                case 4:
                    usuario = new Cliente(usuario);
                    break;
            }
            
        }
        pstmt.close();
        return usuario;
    }
    
    /*public int permissaoUsuario(String login, String senha) throws SQLException{
        Connection conexao = DBConnection.getInstance();
        int permissao;
        String sql = (String) dados.get("SelectPermissao.Usuario");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, login);
        pstmt.setString(2, senha);
        ResultSet rs = pstmt.executeQuery();
        permissao = rs.getInt(1);
        return permissao;
    }*/
}
