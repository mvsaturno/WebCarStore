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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Karen
 */
public class TrataCadastroVeiculo extends Comando {
    
    
   @Override
   public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");
            
            HttpSession session = getRequest().getSession(false);
            
            int modelo = Integer.parseInt(getRequest().getParameter("veiculo_modelo_select")); 
            int ano= Integer.parseInt(getRequest().getParameter("veiculo_ano_select"));
            int categoria= Integer.parseInt(getRequest().getParameter("veiculo_categoria_select"));        
            int combustivel= Integer.parseInt(getRequest().getParameter("veiculo_combustivel_select"));   
            int cor=Integer.parseInt(getRequest().getParameter("veiculo_cor_select")); 
            double quilometragem=Double.parseDouble(getRequest().getParameter("veiculo_quilometragem_cad")); 
            double valor=Double.parseDouble(getRequest().getParameter("veiculo_valor_cad"));
            String motor=getRequest().getParameter("veiculo_motor_cad");
            Veiculo vel=new Veiculo();
            
            
            
            vel.setIdModelo(modelo);            
            vel.setAno(ano);  
            vel.setCategoria(categoria);
            vel.setIdCombustivel(combustivel);
            vel.setIdCor(cor);
            vel.setKm(quilometragem);
            vel.setValor(valor);
            vel.setMotor(motor);
            
            VeiculoDAO veiculo = new VeiculoDAO();
            
            String msg = "";
          
            if (veiculo.inserir(vel))
            {
                 msg = "Inserido com sucesso!";
                 //atualizar sessão com marcas cadastradas
                             }
            else
            {
                 msg = "Erro na inserção!";
            }
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 

            
           // getResponse().sendRedirect("/WEB-INF/cms_admin.jsp");  
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }

}
