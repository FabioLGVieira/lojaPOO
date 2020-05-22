<%-- 
    Document   : index
    Created on : May 20, 2020, 3:40:50 PM
    Author     : Fabio
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
        <meta charset="utf-8">
       <link rel="shortcut icon" href="imagem/muchachos.png">
       <link rel="stylesheet" href="css/estilobootstrap.css">
       <link rel="stylesheet" href="css/componentes.css">
</head>
<body>

 <header class="layout-cabecalho layout-cabecalho--tabela">
      <div class="container">
      
           <%@ include file="botoes.txt" %> 
           
      </div>
    </header>
     <h4 class="titulo-formulario">${mensagem}</h4>
    <img id="img" src="imagem/perf1.jpg" height="600" width="600" style="display: block; margin-left: auto; margin-right: auto; width: 50%;">
    
    
    <footer class="layout-rodape-cos">
        <p>&copy; Muchachos. Todos os direitos reservados.</p>
     </footer>   
 </body>

        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="javaScripts/app.js"></script>
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
            
            $('#img').fadeOut(500, function () {
                $(this).attr('src', images[i]).fadeIn(500);
            })
            i++;
        }
    </script>
</html>