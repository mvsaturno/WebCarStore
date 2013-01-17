/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AnuncioDAO;
import dao.RevendaDAO;
import dao.VeiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Anuncio;
import model.Revenda;
import model.Usuario;
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
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            
            int id_veiculo = Integer.parseInt(getRequest().getParameter("veiculo_select_cad"));
            String data_inicio = getRequest().getParameter("data_inicio_anuncio_cad");
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_inicio);  
            String dataBanco = new SimpleDateFormat("dd-MM-yyyy").format(data);
            
            int status = Integer.parseInt(getRequest().getParameter("status_select_cad"));
            double valor_anuncio = Double.parseDouble(getRequest().getParameter("valor_anuncio_cad"));
            int destaque = Integer.parseInt(getRequest().getParameter("status_anuncio_cad"));
            int id_revenda = usuarioLogado.getRevenda().getId();

            Veiculo veiculo = (Veiculo) new VeiculoDAO().pesquisarChave(id_veiculo);
            Revenda revenda = (Revenda) new RevendaDAO().pesquisarChave(id_revenda);
            
            
            Anuncio anun = new Anuncio(veiculo,dataBanco,status,valor_anuncio,destaque,revenda);
          
            AnuncioDAO cadAnuncio = new AnuncioDAO();

            
            String msg = "";

            if (cadAnuncio.inserir(anun)) {
                msg = "Inserido com sucesso!";
            } else {
                msg = "Erro na inserção!";
            }
            getRequest().setAttribute("mensagem", msg);
            RequestDispatcher rd = getRequest().getRequestDispatcher("/sistema.jsp");
            rd.forward(getRequest(), getResponse());

        } catch (ParseException ex) {
            Logger.getLogger(TrataCadastroAnuncio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
