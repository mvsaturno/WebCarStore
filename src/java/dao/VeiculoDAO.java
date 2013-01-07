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
import model.Categoria;
import model.Combustivel;
import model.Cor;
import model.Item;
import model.Revenda;
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
        //ordem dos parametros:id_modelo, cod_combustivel, id_categoria, id_cor, ano, motor, valor, quilometragem
        String sql = (String) dados.get("Insert.Veiculo");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, vel.getIdModelo());
        stmt.setInt(2, vel.getIdCombustivel());
        stmt.setInt(3, vel.getCategoria());
        stmt.setInt(4, vel.getIdCor());
        stmt.setInt(5, vel.getAno());
        stmt.setString(6, vel.getMotor());
        stmt.setDouble(7, vel.getValor());
        stmt.setDouble(8, vel.getKm());
        
        
        stmt.execute();
        //conexao.close();
        
        return true;
    }
    
    public boolean inserirMarca(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Marca");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1, vel.getMarca());
        
        
        stmt.execute();
        stmt.close();
        return true;
    }
    
    public boolean inserirModelo(Object obj) throws SQLException {
        Veiculo vel = (Veiculo) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Modelo");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(2, vel.getModelo());
        stmt.setInt(1,vel.getIdMarca());
        
        stmt.execute();
        stmt.close();
        return true;
    }
    
    public boolean inserirItem(Object obj) throws SQLException {
        Item item = (Item) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Item");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        stmt.setString(1,item.getNome());
        
        stmt.execute();
        //conexao.close();
        return true;
    }
    
    
    public ArrayList pesquisarMarcas() throws SQLException {
        ArrayList marcaList = new ArrayList();
        Veiculo veiculo = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Marca");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            veiculo = new Veiculo();
            veiculo.setMarca(rs.getString("descricao"));
            veiculo.setIdMarca(rs.getInt("id_marca"));
            marcaList.add(veiculo);
        }
            
            
        
        pstmt.close();
        return marcaList;
    }
    
    public ArrayList pesquisarModelos() throws SQLException {
        ArrayList modeloList = new ArrayList();
        Veiculo veiculo = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Modelo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            veiculo = new Veiculo();
            veiculo.setModelo(rs.getString("descricao"));
            veiculo.setIdModelo(rs.getInt("id_modelo"));
            modeloList.add(veiculo);
        }        
        
        pstmt.close();
        return modeloList;
    }
    
    public ArrayList pesquisarCombustiveis() throws SQLException {
        ArrayList combustivelList = new ArrayList();
        Combustivel combustivel = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Combustivel");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            combustivel = new Combustivel();
            combustivel.setNome(rs.getString("descricao"));
            combustivel.setIdCombustivel(rs.getInt("cod_combustivel"));
            combustivelList.add(combustivel);
        }        
        
        pstmt.close();
        return combustivelList;
    }

     public ArrayList pesquisarCategorias() throws SQLException {
        ArrayList categoriaList = new ArrayList();
        Categoria categoria = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Categoria");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            categoria = new Categoria();
            categoria.setNome(rs.getString("descricao"));
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            categoriaList.add(categoria);
        }        
        
        pstmt.close();
        return categoriaList;
    }
     
     public ArrayList pesquisarCores() throws SQLException {
        ArrayList corList = new ArrayList();
        Cor cor = null;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectAll.Cor");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            cor= new Cor();
            cor.setNome(rs.getString("descricao"));
            cor.setIdCor(rs.getInt("id_cor"));
            corList.add(cor);
        }        
        
        pstmt.close();
        return corList;
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
        //pstmt.close();
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
