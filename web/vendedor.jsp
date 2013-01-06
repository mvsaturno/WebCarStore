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
                <label for="anun_nome_cad">Nome completo:</label>
                <input name="anun_nome_cad" id="user_nome_cad" type="text" size="50" required autofocus/><br/>

                <label for="anun_login_cad">Login:</label>
                <input name="anun_login_cad" id="user_login_cad" type="email" size="50" required/><br/>

                <label for="anun_senha_cad">Senha:</label>
                <input name="anun_senha_cad" id="user_senha_cad" type="password" size="50" required/><br/>           

                <label for="user_celular_cad">Celular:</label>
                <input name="user_celular_cad" id="user_celular_cad" type="tel" size="20" required/><br/>

                <label for="user_telefone_cad">Telefone:</label>
                <input name="user_telefone_cad" id="user_telefone_cad" type="tel" size="20" required/><br/>

                <input type="hidden" name="user_revenda_cad" value="<%=usuario.getRevenda().getId()%>" >

                <label for="user_permissao_cad">Permissão:</label>
                <label class="usuario_label"> 
                    <select class="usuario_select" name="user_permissao_cad" id="user_permissao_cad">
                        <option value=""></option>
                        <option value="1">Administrador</option>
                        <option value="2">Revenda</option>
                        <option value="3">Vendedor</option>                    
                    </select>
                </label>
                <br/>
                <input name="id_anun" type="hidden" id="id_anun" value="">
                <input id="cad_anuncio_cmd" type="hidden" name="cmd" value='trataCadastroAnuncio'>
                <input name="Salvar" type="submit" value="Salvar"/>               
            </fieldset>                  
        </form>
    </div>    
    
        
        
</div>


