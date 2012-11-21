/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Saturno
 */
public interface InterfaceDAO {
    public void inserir (Object obj) throws SQLException;
    
    public void excluir (Object obj) throws SQLException;
    
    public ArrayList pesquisarTudo () throws SQLException;
    
    public Object pesquisarChave (int chave) throws SQLException;
    
    public void editar (Object obj) throws SQLException;
}
