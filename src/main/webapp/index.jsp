<%-- 
    Document   : index
    Created on : May 20, 2020, 3:40:50 PM
    Author     : Fabio
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciamento</title>
        <meta charset="utf-8">
       <link rel="shortcut icon" href="imagem/muchachos.png">
       <link rel="stylesheet" href="css/estilobootstrap.css">
       <link rel="stylesheet" href="css/componentes.css">
</head>
<body>

 <header class="layout-cabecalho layout-cabecalho--tabela">
      <div class="container">
      
       <nav class="navegacao">
          <a href="menu.jsp"><img src="imagem/logo.png" title="HOME"  width="60" height="55" alt="Muchachos" /></a>
          
         <div class="navegacao_menu">
             <button class="botao-chaveador js-botao-chaveador"></button>
             
            <ul  class="menu  js-menu">
             <li class="menu__itens"><a href="funcionarioServlet">Cadastro de Funcionario</a><br></li>
             <li class="menu__itens"><a href="gerenciarFuncionarioServlet">Consulta de Funcionario</a><br></li>
             <li class="menu__itens"> <a href="clienteServlet">Cadastro de Cliente</a><br></li>
             <li class="menu__itens"><a href="gerenciarClienteServlet">Consulta de Cliente</a><br></li>
             <li class="menu__itens"> <a href="produtoServlet">Cadastro de Produto</a><br></li>
             <li class="menu__itens"> <a href="gerenciarProdutoServlet">Consulta de Produto</a><br></li>
             <li class="menu__itens"><a href="buscarVendaServlet">Relatorio de Vendas</a><br></li>
             <li class="menu__itens"> <a href="vendaServlet">Fazer Venda</a><br></li>
             <li class="menu__itens"><a href="index.jsp">Sair</a><br></li>
            </ul>
         </div>   
          </nav>
      </div>
    </header>
     <h4 class="titulo-formulario">${mensagem}</h4>
    <img id="img" src="imagem/perf1.jpg" height="600" width="600" style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
    
    <script src="javaScripts/app.js"></script>
    
    <footer class="layout-rodape-cos">
        <p>&copy; Muchachos. Todos os direitos reservados.</p>
     </footer>   
 </body>
 
    <script>
        var images = [];
        images[0] = "imagem/perf1.jpg";
        images[1] = "imagem/perf2.jpg";
        images[2] = "imagem/perf3.jpg";
        images[3] = "imagem/perf4.jpg";
        images[4] = "imagem/perf5.jpg";
        images[5] = "imagem/cosmeticos_perfumaria.jpg";

        var i = 0;
        setInterval(fadeDivs, 2000);

        function fadeDivs() {
            i = i < images.length-1 ? i : 0;
            console.log(i);
            $('#img').fadeOut(500, function () {
                $(this).attr('src', images[i]).fadeIn(500);
            })
            i++;
        }
    </script>
</html>