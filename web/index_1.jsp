<%-- 
    Document   : index
    Created on : 26/10/2012, 23:58:36
    Author     : Saturno
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>   
    <head>
        <title>WebCar Store - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    

        <style>
            
            
        </style>
    </head>
    <body>
        <div id="tudo">
            <div id="topo">
                <img src="img/logotipo.png" alt="WebCar Store" border="0" />
                <div id="titulo">
                    <h1>WebCar Store</h1>
                    <h3>Sistema CMS</h3>
                </div>
                <div id="logado">
                    <img src="img/user.png" alt="NomeUsuário" border="0" />
                    <div class="text"> 
                        Bem-vindo:<br/>
                        <span>Usuário Usarêncio</span><br/>
                        <a href="#">Sair</a>
                    </div>
                </div>
            </div>
            <div id="menu_admin">
                <ul>
                    <li><a href="#" onclick="usuarios()">Usuários</a></li>
                    <li><a href="#" onclick="revendas()">Revendas</a></li>           
                    <li><a href="#" onclick="layouts()">Layouts</a></li>
                    <li><a href="#" onclick="planos()">Planos</a></li>
                </ul>                
            </div>
            <div id="conteudo">

                <%@ include file="conteudo.jsp" %>

            </div>
            <div id="rodape">WebCar Store - 2012</div>
        </div>
    </body>
</html>

