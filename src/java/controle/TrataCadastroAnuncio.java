/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Veiculo;

/**
 *
 * @author Cícero
 */
public class TrataCadastroAnuncio extends Comando {

    @Override
    public void execute() throws ServletException, IOException, SQLException, ClassNotFoundException {
        getResponse().setContentType("text/html;charset=UTF-8");
        PrintWriter out = getResponse().getWriter();
        try {
            getResponse().setContentType("text/html");

            HttpSession session = getRequest().getSession(false);
            
Insert.Anuncio=INSERT INTO ANUNCIO (id_anuncio, id_veiculo, data, id_status, valor_vendido, destaque, id_revenda) values (SEQ_ANUNCIO.nextval,?,?,?,?,?,?)
            

            int veiculo = Integer.parseInt(getRequest().getParameter("veiculo_modelo_select"));
            int ano = Integer.parseInt(getRequest().getParameter("veiculo_ano_select"));
            int categoria = Integer.parseInt(getRequest().getParameter("veiculo_categoria_select"));
            int combustivel = Integer.parseInt(getRequest().getParameter("veiculo_combustivel_select"));
            int cor = Integer.parseInt(getRequest().getParameter("veiculo_cor_select"));
            double quilometragem = Double.parseDouble(getRequest().getParameter("veiculo_quilometragem_cad"));
            double valor = Double.parseDouble(getRequest().getParameter("veiculo_valor_cad"));
            String motor = getRequest().getParameter("veiculo_motor_cad");
            Veiculo vel = new Veiculo();

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

            if (veiculo.inserir(vel)) {
                msg = "Inserido com sucesso!";
                //atualizar sessão com marcas cadastradas
            } else {
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
