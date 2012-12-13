<div class="divs" id="usuarios">
    <h3>Gerenciamento de Usuários:</h3>
    <br/>
    <input type="text" placeholder="Procurar"/>

    <a href="#" onclick="cadastrar()" class="btn_cadastrarUser">
        <span>Cadastar novo usuário</span>
    </a>
    <br/><br/>
    <table>
        <tr class="gray2">
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Revenda</th>
            <th>Login</th>
            <th>Permissão</th>
            <th>Data Cadastro</th>
            <th>Editar</th>
            <th>Excluir</th>
        </tr>

        <% for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
        %>
        <tr class="white">
            <%  } else {%>
        <tr class="gray">
            <% }%>
            <td>oi</td>
            <td>a</td>
            <td>b</td>
            <td>c</td>
            <td>d</td>
            <td>e</td>
            <td><img src="img/edit.png" border="0" alt="Editar"/></td>
            <td><img src="img/delete.png" border="0" alt="Excluir"/></td>
        </tr>
        <% }%>
    </table>
</div>

<div class="divs" id="cadastrarUsuario">
    <h3>Cadastro de Usuário:</h3>    
    <form method="post" action="#">
        <fieldset>   
                 
                    <label for="nome">Nome completo:</label>
                    <input name="nome" type="text" size="50" required autofocus/><br/>
                
                    <label for="login">Login:</label>
                    <input name="login" type="text" size="50" required/><br/>
                
                    <label for="senha">Senha:</label>
                    <input name="senha" type="password" size="50" required/><br/>
                
                    <label for="permissao">Permissão:</label>
                    <input type="text" list="permissoes" size="50">                  
                    <datalist id="permissoes" >
                        <option value="1"> Administrador </option>
                        <option value="2"> Revenda </option>
                        <option value="3"> Vendedor </option>    
                    </datalist><br/> 
                
                    <label for="nascimento">Data de Nascimento:</label>
                    <input name="nascimento" type="date" size="50" required /><br/>
                    <input type="hidden" name="cmd" value='trataCadastroUsuario'>
                    <input name="Salvar" type="submit" value="Salvar"/>
               
        </fieldset>                  
    </form>
</div>


<div class="divs" id="revendas">
    Revendas
</div>

<div class="divs" id="layouts">
    Layouts

</div>

<div class="divs" id="planos">
    Planos

</div>