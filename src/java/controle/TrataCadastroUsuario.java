  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import model.*;
import dao.*;
import java.sql.SQLException;
import javax.servlet.ServletException;

/**
 *
 * @author Karen
 */
public class TrataCadastroUsuario extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
            
            DateFormat df = DateFormat.getDateTimeInstance();
            String nome = getRequest().getParameter("cad_nome");
            String login = getRequest().getParameter("cad_login");
            String senha = getRequest().getParameter("cad_senha");
            String revenda = getRequest().getParameter("cad_revenda");
            
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setLogin(login);
            user.setSenha(senha);
            user.setRevenda(null);
            new UsuarioDAO().inserir(user);
            
            getResponse().sendRedirect("usuarioCadastrado.jsp");  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }

}
