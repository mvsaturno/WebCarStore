/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Anuncio;
import util.PropertiesManager;

/**
 *
 * @author Saturno
 */
public class AnuncioDAO implements InterfaceDAO {
    private HashMap dados;
    
    public AnuncioDAO() throws IOException {
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }

    
    
    @Override
    public boolean inserir(Object obj) throws SQLException {
        Anuncio announce = (Anuncio) obj;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Anuncio");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setObject(1, announce.getVeiculo());
        stmt.setString(2, announce.getData_inicio());
        stmt.execute();
        conexao.close();
        return true;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        return true;
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean editar(Object obj) throws SQLException {
        return true;
    }
    
}
