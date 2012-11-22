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
        <title>WebCar Store - Módulo Administrador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--Carrega JQuery e JS do menu de imagens-->
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.navega.js"></script>

        <style>
            /* CSS Reset */

            html, body, div, span, applet, object, iframe,
            h1, h2, h3, h4, h5, h6, p, blockquote, pre,
            a, abbr, acronym, address, big, cite, code,
            del, dfn, font, img, ins, kbd, q, s, samp,
            small, strike, sub, sup, tt, var,
            dl, dt, dd, ol, ul, li,
            fieldset, form, label, legend,
            table, caption, tbody, tfoot, thead, tr, th, td {
                margin: 0;
                padding: 0;
                border: 0;
                outline: 0;
                font-weight: inherit;
                font-style: inherit;
                font-size: 100%;
                font-family: inherit;
                vertical-align: baseline; }

            ol, ul { list-style: none; }            

            body{
                text-align: center;
            }
            #tudo{
                width: 1024px;
                margin: 10px auto;
                text-align: left;
                font-family: arial,tahoma,verdana;               
            }
            #topo{
                position: relative;
                height: 110px;
                padding: 10px;
                border-bottom: 1px solid #000;
            }
            #topo img {
                float:left;
            }
            #titulo {
                margin: 15px;
                float:left;     
            }
            h1 {
                font-size: 36px;
                font-weight: bold;
            }
            h3 {
                font-size: 18px;
            }
            #logado{
                padding: 10px;
                float:right;
                width: 250px;
            }
            #logado img {
                float: left;
            }
            #logado .text{
                float: right;
                font-size: 16px;
                line-height: 160%;
            }
            #logado .text span{
                font-weight: bold;
                color: #0066ff;
            }
            #logado .text a{
                color: red;
                float: right;
            }

            #menu_admin{
                margin: 10px auto;
                width: 430px;
                height: 50px;
            }
            menu_admin ul {                
                border: 1px solid #ccc;

            }
            #menu_admin ul li{
                padding: 2px;
                float: left;               
                text-align: center;
                border: 1px solid #ccc;             
            }
            #menu_admin ul li a{
                width: 100px;
                height: 30px;
                display: block;
                color: #000;
                padding-top: 12px;
                text-decoration: none;
                background-color: #eee;
            }
            #menu_admin ul li a:hover{
                background-color: #fff;
                color: #666;
            }

            #conteudo {
                position: relative;
                height: 500px;
            }

            .divs {
                display: none;
            }

            #usuarios{
                position: relative;
                margin: 15px auto;
            }

            .btn_cadastrarUser{
                background: url('img/cadastrar.png') no-repeat right bottom;
                padding-right: 35px; 
                float: right;              
                height: 30px;
                color: #000;
                text-decoration: none;
                font-weight: bold; 
                vertical-align: middle;
                display: table-cell;
            }    

            #usuarios table {
                font-size: 95%;
                border: 1px dotted #666;
                width: 100%;
            }

            #usuarios tr.gray2 {
                background: #ddd;
            }

            #usuarios th {
                height: 1.3em;
                text-align: center;
                font-weight: bold;
            }


            #usuarios tr.gray {
                background: #eee;
            }

            #usuarios tr.white {
                background: #fff;
            }

            #usuarios td {
                height: 1.3em;
                text-align: center;
            }

            #cadastrarUsuario form{
                margin: 20px auto;
                width: 500px;
                position: relative;
            }

            label,  input {
                display: block;
                float: left;
            }

            label {	
                text-align: left;
                width: 150px;
                padding-right: 20px;
                padding-bottom: 10px;
            }            

            br {
                clear: left;
            }

            #rodape{
                text-align: center;
                height: 30px;
            }
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

