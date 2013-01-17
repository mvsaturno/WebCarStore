<%-- 
    Document   : revenda
    Created on : 26/10/2012, 23:58:36
    Author     : Saturno

    Comments   : Esta pagina servira para os seguintes casos de uso:

    2 - Editar Revenda
    3 - Desativar Revenda
    
    7 - Gerenciar Anuncios:
    14 - Cadastrar anuncios
    15 - Remover anuncios
    16 - Publicar anuncios
    17 - Encerrar anuncios
    20 - Consultar anuncios
    26 - Alterar anuncios
--%>

<%@page import="model.Revenda"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.RevendaDAO"%>
<div id="menu_admin">
    <ul>
        <li><a href="#" onclick="revendas()">Revenda</a></li>
        <li><a href="#" onclick="anuncios()">Anuncios</a></li>
        <!-- <li><a href="#" onclick="veiculos()">Veiculos</a></li>
        <li><a href="#" onclick="layouts()">Layouts</a></li>
        <li><a href="#" onclick="planos()">Planos</a></li> -->
    </ul>                
</div>

<div id="conteudo">
    
    <div class="divs listagem" id="revendas">

        <h3>Gerenciamento de Revendas</h3>
        <br/>

        <table>
            <tr class="gray2">
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Numero</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado(UF)</th>
                <th>Data Cadastro</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>


            <%
                RevendaDAO comando = new RevendaDAO();
                ArrayList revendas = comando.pesquisarTudo();
                Iterator itr = revendas.iterator();
                while (itr.hasNext()) {
                    Revenda revenda = (Revenda) itr.next();
            %>

            <tr class="gray">
                <td><%=revenda.getCNPJ()%></td>
                <td><%=revenda.getNome()%></td>
                <td><%=revenda.getFone()%></td>
                <td><%=revenda.getEmail()%></td>
                <td><%=revenda.getEndereco()%></td>
                <td><%=revenda.getNumero()%></td>
                <td><%=revenda.getBairro()%></td>
                <td><%=revenda.getCidade()%></td>
                <td><%=revenda.getEstado()%></td>
                <td><%=revenda.getData_cadastro()%></td>
                
                <td>
                    <img src="img/edit.png" border="0" alt="Editar" onclick='editarRevenda("<%=revenda.getId()%>","<%=revenda.getCNPJ()%>","<%=revenda.getNome()%>","<%=revenda.getFone()%>","<%=revenda.getEmail()%>","<%=revenda.getEndereco()%>","<%=revenda.getNumero()%>","<%=revenda.getBairro()%>","<%=revenda.getCidade()%>","<%=revenda.getEstado()%>")'/>
                </td>
                <td class="img_crud">
                    <form method="post" action="FrontController">
                        <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                        <input type="hidden" name="cmd" value="trataExcluirRevenda">
                        <input type="hidden" name="id_revenda_excluir" value="<%=revenda.getId()%>">
                    </form>
                </td>
            </tr>
            <% } %>

    </table>
    </div>
    
</div>