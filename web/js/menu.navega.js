function index(){
	$('div.divs').stop().slideUp();
	$('#home').stop().slideDown();
}

function usuarios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#usuarios').stop().slideDown();
}

function cadastrarUsuarios(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarUsuarios').stop().slideDown();                        
        var arr = new Array();  
        arr = document.getElementsByTagName("input");            
        for (var i = 0; i < arr.length; i++) {
            if ((arr[i].type != "submit")&&(arr[i].type != "hidden")&&(arr[i].type != "button")&&(arr[i].type != "image")){
                arr[i].value = "";
            }
        }
        document.getElementById("user_permissao_cad").options[0].selected = true;
        document.getElementById("cad_usuario_cmd").value = "trataCadastroUsuario";
        document.getElementById("cad_usuario_title").innerHTML = "Cadastro de Usuário:";       
}

function editarUsuario(id){
        cadastrarUsuarios();
        document.getElementById("user_nome_cad").value = id;
        document.getElementById("user_login_cad").value = id;
        document.getElementById("user_senha_cad").value = id;
        document.getElementById("user_celular_cad").value = id;
        document.getElementById("user_telefone_cad").value = id;
        document.getElementById("user_permissao_cad").options[1].selected = true;
        document.getElementById("cad_usuario_cmd").value = "trataEditaUsuario";
        document.getElementById("cad_usuario_title").innerHTML = "Edição de Usuário:";
}

function cadastrarVeiculos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarVeiculos').stop().slideDown();
}

function cadastrarModelos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarModelos').stop().slideDown();
}

function cadastrarMarcas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarMarcas').stop().slideDown();
}

function cadastrarItens(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarItens').stop().slideDown();
}

function cadastrarRevendas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#cadastrarRevendas').stop().slideDown();
}

function revendas(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#revendas').stop().slideDown();
}

function veiculos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#veiculos').stop().slideDown();
}
				
function layouts(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#layouts').stop().slideDown();
}
			
function planos(){
	window.scrollTo(0,200);
	$('div.divs').stop().slideUp();
	$('#planos').stop().slideDown();
}	