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
public class TrataExcluirUsuario extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
         
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            Administrador admin = (Administrador) session.getAttribute("usuario");
            
            String num = getRequest().getParameter("user_id_excluir");
            int id = Integer.parseInt(num);
            String msg = admin.deletarUsuario(id);
            
            out.println(msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/cms_admin.jsp");
            rd.include(getRequest(), getResponse()); 

         }   
           // getResponse().sendRedirect("/WEB-INF/cms_admin.jsp");  
    }