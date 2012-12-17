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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

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
            
            HttpSession session = getRequest().getSession(false);
            Administrador admin = (Administrador) session.getAttribute("usuario");
            
            String nome = getRequest().getParameter("cad_nome");
            String login = getRequest().getParameter("cad_login");
            String senha = getRequest().getParameter("cad_senha");
            int permissao = Integer.parseInt(getRequest().getParameter("cad_permissao"));
            int id_revenda = Integer.parseInt(getRequest().getParameter("cad_revenda"));
            int celular = Integer.parseInt(getRequest().getParameter("cad_celular"));
            int telefone = Integer.parseInt(getRequest().getParameter("cad_telefone"));
            
            Revenda revenda = (Revenda) new RevendaDAO().pesquisarChave(id_revenda);
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setLogin(login);
            user.setSenha(senha);
            user.setRevenda(revenda);
            user.setPermissao(permissao);
            user.setCelular(celular);
            user.setTelefone(telefone);
            
            String msg = admin.cadastrarUsuario(user);
            
            out.println(msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/WEB-INF/cms_admin.jsp");
            rd.include(getRequest(), getResponse()); 

            
           // getResponse().sendRedirect("/WEB-INF/cms_admin.jsp");  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }

}
