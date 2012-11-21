/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import model.Revenda;
import util.PropertiesManager;

/**
 *
 * @author Saturno
 */
public class RevendaDAO implements InterfaceDAO{

    private HashMap dados;

    public RevendaDAO() throws IOException {
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }
    
    @Override
    public void inserir(Object obj) throws SQLException {
        Revenda rev = (Revenda) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Revenda");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, rev.getNome());
        stmt.setString(2, rev.getEndereco());
        stmt.setString(3, rev.getCNPJ());
        stmt.setString(4, rev.getFone());
        stmt.setString(5, rev.getSetor());
        stmt.setString(6, rev.getEmail());
        stmt.execute();
        conexao.close();
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList revList = new ArrayList();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Revenda");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            Revenda r = new Revenda();
            r.setId(rs.getInt(1));
            revList.add(r);
        }
        pstmt.close();
        return revList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Revenda pesquisarLogin(String login) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Revenda usuario = null;
        String sql = (String) dados.get("SelectByLogin.Revenda");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, login);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            //Completar depois.
        }
        pstmt.close();
        return usuario;
    }
}
