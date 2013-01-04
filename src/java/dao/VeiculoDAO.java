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
import model.Veiculo;
import util.PropertiesManager;

/**
 *
 * @author saturno
 */
public class VeiculoDAO  implements InterfaceDAO{
 private HashMap dados;
 
 public VeiculoDAO() throws IOException {
     dados = new PropertiesManager("sql.properties").readPropertiesFile();     
 }

    @Override
    public boolean inserir(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Veiculo");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, vel.getNome());
        stmt.setString(2, vel.getMarca());
        stmt.setString(3, vel.getModelo());
        stmt.setString(4, vel.getCor());
        stmt.setString(5, vel.getMotor());
        stmt.setString(6, vel.getCombustivel());
        stmt.setString(7, vel.getOpcionais());
        stmt.execute();
        conexao.close();
        
        return true;
    }
    
    public boolean inserirMarca(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Marca");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, vel.getMarca());
        
        stmt.execute();
        //conexao.close();
        return true;
    }


    @Override
    public boolean excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList velList = new ArrayList();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Veiculo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            Veiculo v = new Veiculo();
            v.setId(rs.getInt(1));
            velList.add(v);
        }
        pstmt.close();
        return velList;
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
