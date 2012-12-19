<%@page import="java.sql.SQLException"%>
<%@page import="java.io.IOException"%>
<%@page import="model.Administrador"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsuarioDAO"%>
<div class="divs" id="usuarios">
    <h3>Gerenciamento de Usuários:</h3>
    <br/>
    <input type="text" placeholder="Procurar"/>

    <a href="#" onclick="cadastrarUsuarios()" class="btn_cadastrar">
        <span>Cadastar novo usuário</span>
    </a>
    
    <br/>
    <br/>
    
    <table>
        <tr class="gray2">
            <th>Nome</th>
            <th>Revenda</th>
            <th>Login</th>
            <th>Permissão</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>

        <%

            Administrador admin = (Administrador) usuario;
            ArrayList users = admin.listarUsuarios();
            Iterator it = users.iterator();
            while (it.hasNext()) {
                int i = 0;
                Usuario user = (Usuario) it.next();
                if (i % 2 == 0) {
        %>
        <tr class="white">
            <%  } else {%>
        <tr class="gray">
            <% }%>
            <td><%=user.getNome()%></td>
            <td><%=user.getRevenda().getNome()%></td>
            <td><%=user.getLogin()%></td>
            <td><%=user.getPermissao()%></td>
            <td>
                <img src="img/edit.png" border="0" alt="Editar" onclick='editarUsuario("<%=user.getNome()%>","<%=user.getLogin()%>","<%=user.getSenha()%>",<%=user.getCelular()%>,<%=user.getTelefone()%>,<%=user.getPermissao()%>)'/></td>                   

            <td class="img_crud">
                <form method="post" action="FrontController">
                    <input type="image" src="img/delete.png" alt="Excluir" title="Excluir" name="excluir">
                    <input type="hidden" name="cmd" value="trataExcluirUsuario">
                    <input type="hidden" name="user_id_excluir" value="<%=user.getId()%>">                   
                </form>
            </td>
        </tr>
        <% i++;
            }

        %>
    </table>
</div>

<div class="divs" id="revendas">
    <a href="#" onclick="cadastrarRevendas()" class="btn_cadastrar">
        <span>Cadastar Revendas</span>
    </a>
</div>

<div class="divs" id="veiculos">
    <a href="#" onclick="cadastrarVeiculos()" class="btn_cadastrar">
        <span>Cadastar veículos</span>
    </a>
    <a href="#" onclick="cadastrarModelos()" class="btn_cadastrar">
        <span>Cadastar modelos</span>
    </a>
    <a href="#" onclick="cadastrarMarcas()" class="btn_cadastrar">
        <span>Cadastar marcas</span>
    </a>
    <a href="#" onclick="cadastrarItens()" class="btn_cadastrar">
        <span>Cadastar Itens Opcionais</span>
    </a>
</div>

<div class="divs" id="layouts">
    Layouts
</div>

<div class="divs" id="planos">
    Planos
</div>

<div class="divs" id="cadastrarUsuarios">
    <h3 id="cad_usuario_title">Cadastro de Usuário:</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>
            <label for="user_nome_cad">Nome completo:</label>
            <input name="user_nome_cad" id="user_nome_cad" type="text" size="50" required autofocus/><br/>

            <label for="user_login_cad">Login:</label>
            <input name="user_login_cad" id="user_login_cad" type="email" size="50" required/><br/>

            <label for="user_senha_cad">Senha:</label>
            <input name="user_senha_cad" id="user_senha_cad" type="password" size="50" required/><br/>           

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

            <input id="cad_usuario_cmd" type="hidden" name="cmd" value='trataCadastroUsuario'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>
</div>

<div class="divs" id="cadastrarRevendas">                
    <h3>Cadastro de Revendas:</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>
            <label for="revenda_descricao_cad">CNPJ:</label>
            <input name="revenda_cnpj_cad" type="text" size="50" required autofocus/><br/>

            <label for="revenda_nome_cad">Nome:</label>
            <input name="revenda_nome_cad" type="text" size="50" required/><br/>

            <label for="revenda_telefone_cad">Telefone:</label>
            <input name="revenda_telefone_cad" type="text" size="50" required/><br/>

            <label for="revenda_mail_cad">E-mail:</label>
            <input name="revenda_mail_cad" type="text" size="50" required/><br/>

            <label for="revenda_ativo_cad">Ativo?</label><br/>         
            <input name="revenda_ativo_cad" type="radio" value="1"> Sim<br/>
            <input name="revenda_ativo_cad" type="radio" value="2"> Não<br/>


            <input type="hidden" name="cmd" value='trataCadastroRevenda'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>   
</div>

<div class="divs" id="cadastrarVeiculos">
    <h3>Cadastro de Veículo:</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>                                 
            <label>Modelo:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <option value="01">Gol</option>
                    <option value="02">Clio</option>
                    <option value="03">Ka</option>                    
                </select>
            </label>
            <br/>

            <label>Combustível:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <option value="01">Gasolina</option>
                    <option value="02">Alcool</option>
                    <option value="03">GNV</option>
                </select>
            </label>            
            <br/>

            <label>Categoria:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <option value="01">Carro</option>
                    <option value="02">Moto</option>
                    <option value="03">Caminhão</option>                    
                </select>
            </label>            
            <br/>

            <label>Cor:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <option value="01">Azul</option>
                    <option value="02">Prata</option>
                    <option value="03">Verde</option>                    
                </select>
            </label>
            <br/>

            <label>Ano:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <% for (int i = 1950; i <= 2013; i++) {%>
                    <option value=<%=i%>><%=i%></option>
                    <% }%>  
                </select>
            </label>
            <br/>

            <label for="veiculo_motor_cad">Motor</label>
            <input name="veiculo_motor_cad" type="text" size="50" required/><br/>

            <label for="veiculo_valor_cad">Valor</label>
            <input name="veiculo_valor_cad" type="text" size="50" required/><br/>

            <label for="veiculo_quilometragem_cad">Quilometragem</label>
            <input name="veiculo_quilometragem_cad" type="text" size="50" required/><br/>          

            <input type="hidden" name="cmd" value='trataCadastroVeiculo'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>
</div>

<div class="divs" id="cadastrarModelos">                
    <h3>Cadastro de Modelo:</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>

            <label for="veiculo_modelo_cad">Modelo</label>
            <input name="veiculo_modelo_cad" type="text" size="50" required autofocus/><br/>

            <label>Marca:</label>
            <label class="veiculo_label"> 
                <select class="veiculo_select" name="veiculo_select">
                    <option value=""></option>
                    <option value="01">Fiat</option>
                    <option value="02">Wolkswagen</option>
                    <option value="03">Renault</option>                    
                </select>
            </label>            
            <br/>

            <input type="hidden" name="cmd" value='trataCadastroModelo'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>   
</div>


<div class="divs" id="cadastrarMarcas">                
    <h3>Cadastro de Marca:</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>

            <label for="veiculo_marca_cad">Marca:</label>
            <input name="veiculo_marca_cad" type="text" size="50" required autofocus/><br/>

            <input type="hidden" name="cmd" value='trataCadastroMarca'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>   
</div>

<div class="divs" id="cadastrarItens">                
    <h3>Cadastro de itens opcionais</h3>
    <br/>
    <form method="post" action="FrontController">
        <fieldset>
            <label for="veiculo_itens_cad">Item:</label>
            <input name="veiculo_itens_cad" type="text" size="50" required autofocus/><br/>

            <input type="hidden" name="cmd" value='trataCadastroItens'>
            <input name="Salvar" type="submit" value="Salvar"/>               
        </fieldset>                  
    </form>   
</div>