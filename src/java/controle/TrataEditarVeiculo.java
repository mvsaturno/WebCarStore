/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.VeiculoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import model.Veiculo;

/**
 *
 * @author Fabio-CS
 */
public class TrataEditarVeiculo extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            getResponse().setContentType("text/html;charset=UTF-8");
            
            int id = Integer.parseInt(getRequest().getParameter("id_veiculo_alt"));
            int modelo = Integer.parseInt(getRequest().getParameter("veiculo_modelo_select")); 
            int ano= Integer.parseInt(getRequest().getParameter("veiculo_ano_select"));
            int categoria= Integer.parseInt(getRequest().getParameter("veiculo_categoria_select"));        
            int combustivel= Integer.parseInt(getRequest().getParameter("veiculo_combustivel_select"));   
            int cor=Integer.parseInt(getRequest().getParameter("veiculo_cor_select")); 
            double quilometragem=Double.parseDouble(getRequest().getParameter("veiculo_quilometragem_cad")); 
            double valor=Double.parseDouble(getRequest().getParameter("veiculo_valor_cad"));
            String motor=getRequest().getParameter("veiculo_motor_cad");
            Veiculo vel=new Veiculo();
                
            vel.setId(id);
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
          
            if (veiculo.editar(vel))
            {
                 msg = "Editado com sucesso!";
            }else{
                 msg = "Erro na Edição!";
            }
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse()); 
            
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } 
    }
    
}
