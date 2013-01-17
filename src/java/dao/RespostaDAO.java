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
import model.Resposta;
import model.Revenda;
import util.PropertiesManager;

/**
 *
 * @author Jonas
 */
public class RespostaDAO implements InterfaceDAO{

    private HashMap dados;

    public RespostaDAO() throws IOException {
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
    }
    
    @Override
    public boolean inserir(Object obj) throws SQLException {
        Resposta resposta = (Resposta) obj;
        Connection conexao = DBConnection.getInstance();
        
        String sql = (String) dados.get("Insert.Resposta");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1,resposta.getResposta()) ;
        stmt.setInt(2,resposta.getVendedor().getId());
        
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        Integer num = (Integer) obj;
        int id = num.intValue();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Deleta.Resposta");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        return true;
    }

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
        ArrayList respList = new ArrayList();
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectRespostaVendedor");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()){
            Resposta r = new Resposta();
            r.setId_resposta(rs.getInt("id_resposta"));
            r.setResposta(rs.getString("descricao"));
            r.setVendedor(rs.getInt("id_vendedor"));
            
           
            respList.add(r);
        }
        pstmt.close();
        return respList;
    }

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Revenda r = null;
        String sql = (String) dados.get("SelectById.Revenda");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, chave);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            r = new Revenda();
            r.setId(rs.getInt("id_revenda"));
            r.setCNPJ(rs.getLong("cnpj"));
            r.setNome(rs.getString("nome"));
            r.setEmail(rs.getString("mail"));
            r.setEndereco(rs.getString("endereco"));
            r.setNumero(rs.getInt("numero"));
            r.setCidade(rs.getString("cidade"));
            r.setEstado(rs.getString("estado"));
            r.setBairro(rs.getString("bairro"));
            r.setData_cadastro(rs.getString("data_cadastro"));
            r.setFone(rs.getLong("telefone"));
        }
        pstmt.close();
        return r;
    }

    public Object pesquisarNome(String nome) throws SQLException {
        Connection conexao = DBConnection.getInstance();
        Revenda r = null;
        
        String sql = (String) dados.get("SelectByName.Revenda");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(3, nome);
        ResultSet rs = pstmt.executeQuery();
        
        while (rs.next()) {            
            r = new Revenda();
            r.setId(rs.getInt("id_revenda"));
            r.setCNPJ(rs.getLong("cnpj"));
            r.setNome(rs.getString("nome"));
            r.setEmail(rs.getString("email"));
            r.setEndereco(rs.getString("endereco"));
            r.setNumero(rs.getInt("numero"));
            r.setCidade(rs.getString("cidade"));
            r.setEstado(rs.getString("estado"));
            r.setBairro(rs.getString("bairro"));
            r.setData_cadastro(rs.getString("data_cadastro"));
            r.setFone(rs.getLong("telefone"));
        }
        pstmt.close();
        return r;
    }
    
    @Override
    public boolean editar(Object obj) throws SQLException {
        Revenda rev = (Revenda) obj;
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Update.Revenda");
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, rev.getNome());
        stmt.setLong(2, rev.getCNPJ());
        stmt.setString(3, rev.getEmail());
        stmt.setString(4, rev.getEndereco());
        stmt.setInt(5, rev.getNumero());
        stmt.setString(6, rev.getCidade());
        stmt.setString(7, rev.getEstado());
        stmt.setString(8, rev.getBairro());
        stmt.setLong(9, rev.getFone());
        stmt.setInt(10, rev.getAtivo());
        stmt.setInt(11, rev.getId());

        stmt.execute();
        stmt.close();
        return true;
    }
}
