<%@page import="model.Anuncio"%>
<%@page import="dao.AnuncioDAO"%>
<%@page import="model.Revenda"%>
<%@page import="dao.RevendaDAO"%>
<%@page import="model.Veiculo"%>
<%@page import="controle.TrataListaMarcas"%>
<%@page import="dao.VeiculoDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<div id="menu_admin">
    <ul>
        <li><a href="#" onclick="anuncios()">Anúncios</a></li>     
        <li><a href="#" onclick="visitas()">Visitas</a></li>
    </ul>                
</div>

<div id="conteudo">
    <div class="divs listagem" id="anuncios">
        <h3>Gerenciamento de Anúncios</h3>
        <br/>
        
        <a href="#" onclick="cadastrarAnuncios()" class="btn_cadastrar">
            <span>Cadastar novo anúncio</span>
        </a>

        <br/>
        <br/>

        <table>
            <tr class="gray2">
                <th>Título</th>
                <th>Veículo</th>
                <th>Data de Início</th>
                <th>Status</th>
                <th>Destaque</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <% /*
                Usuario usuarioLogado = (Usuario) usuario;
                AnuncioDAO anuncio = new AnuncioDAO();
                ArrayList anuncios = anuncio.pesquisarTudo();
                Iterator it = anuncios.iterator();
                while (it.hasNext()) {
                    int i = 0;
                    Anuncio anun = (Anuncio) it.next();
                    if (i % 2 == 0) {
            */%>
            
            <tr class="white">
                <% /*  } else { */%>
            <tr class="gray">
                <% /* } */%>
                <td><% /* =anun.getTitulo() */%></td>
                <td><% /* =anun.getVeiculo().getModelo().getDescricao()*/%></td>
                <td><% /* =anun.getData() */%></td>
                <td><% /* =anun.getStatus() */%></td>
                <td><% /*=anun.getDestaque() */%></td>
                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarAnuncio()'/></td>                   

                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirAnuncio">
                        <input type="hidden" name="anuncio_id_excluir" value="<% /*=anun.getId() */%>">                   
                    </form>
                </td>
            </tr>
            <% /* i++;
                }   */       %>
        </table>
    </div>

        
        
    <div class="divs" id="cadastrarAnuncios">
        <h3 id="cad_anuncio_title">Cadastro de Anúncio:</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
                  <label>Veiculo:</label>
                <%
                    ArrayList listaVeiculos = new VeiculoDAO().pesquisarTudo();
                    session.setAttribute("listaVeiculos", listaVeiculos);
                    ArrayList listaStatus = new AnuncioDAO().pesquisarTudoStatus();
                    session.setAttribute("listaStatus", listaStatus);
                %>  

                <label class="veiculo_label"> 
                    <select class="veiculo_select" name="veiculo_select_cad">
                        <c:forEach items="${listaVeiculos}" var="veiculo">
                            <option value='<c:out value="${veiculo.id}"/>'><c:out value="${veiculo.id} - ${veiculo.modelo}/${veiculo.ano}"/></option>
                        </c:forEach>                  
                    </select>
                </label>
                <br/>
                <label class="veiculo_label"> 
                    <select class="veiculo_select" name="status_select_cad">
                        <c:forEach items="${listaStatus}" var="status">
                            <option value='<c:out value="${status.idStatus}"/>'><c:out value="${status.descricao}"/></option>
                        </c:forEach>                  
                    </select>
                </label>
                <br>
                <input type="date" id="data_inicio_anuncio_cad" name="data_inicio_anuncio_cad">
                <!--Select Status-->
                <input type="text" id="valor_anuncio_cad" name="valor_anuncio_cad">
                <input type="range" min="0" max="1">
                <input type="hidden" value="<%= usuario.getRevenda().getId()%>">
        
                <br/>
                <input name="id_anuncio" type="hidden" id="id_anuncio" value="">
                <input id="cad_anuncio_cmd" type="hidden" name="cmd" value='trataCadastroAnuncio'>
                <input name="Salvar" type="submit" value="Salvar"/>               
            </fieldset>                  
        </form>
    </div>    
    
    
    <div class="divs listagem" id="visitas">
        <h3>Gerenciamento de Visitas</h3>
        <br/>
        
        <a href="#" onclick="cadastrarVisitas()" class="btn_cadastrar">
            <span>Cadastar nova visita</span>
        </a>

        <br/>
        <br/>

        <table>
            <tr class="gray2">
                <th>ID Anuncio</th>
                <th>Data</th>
                <th>Status</th>
                <th>Veículo</th>
                <th>Valor</th>
                <th>Destaque</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>

            <% 
                AnuncioDAO cmAnuncio = new AnuncioDAO();
                ArrayList anuncios = cmAnuncio.pesquisarTudo();
                Iterator itan = anuncios.iterator();
                while (itan.hasNext()) {
                    int lineAn = 0;
                    Anuncio anuncio = (Anuncio) itan.next();
                    if (lineAn % 2 == 0) {
            /*  private int id;
    private Veiculo veiculo;
    private String data_inicio;
    private int status;
    private double valor_anuncio;
    private int destaque;
    private Revenda revenda;*/
            %>
            
            <tr class="white">
                <%} else {%>
            <tr class="gray">
                <%}%>
                <td><% /* =anuncio.getTitulo() */%></td>
                <td><% /* =anuncio.getVeiculo().getModelo().getDescricao()*/%></td>
                <td><% /* =anuncio.getData() */%></td>
                <td><% /* =anuncio.getStatus() */%></td>
                <td><% /*=anuncio.getDestaque() */%></td>
                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarVisita()'/></td>                   

                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirVisita">
                        <input type="hidden" name="visita_id_excluir" value="<% /*=anun.getId() */%>">                   
                    </form>
                </td>
            </tr>
            <% /* i++;
                }   */       %>
        </table>
    </div>

        
        
    <div class="divs" id="cadastrarVisitas">
        <h3 id="cad_visita_title">Cadastro de Visita</h3>
        <br/>
        <form method="post" action="FrontController">
            <fieldset>
               
                
                
                <br/>
                <input name="id_anun" type="hidden" id="id_visita" value="">
                <input id="cad_visita_cmd" type="hidden" name="cmd" value='trataCadastroVisita'>
                <input name="Salvar" type="submit" value="Salvar"/>               
            </fieldset>                  
        </form>
    </div>            
                
            
        
</div>