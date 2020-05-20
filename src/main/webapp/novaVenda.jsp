<%-- 
    Document   : novaVenda
    Created on : May 15, 2020, 4:54:39 PM
    Author     : Fabio
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="imagem/muchachos.png">
<link rel="stylesheet" href="css/estilobootstrap.css">
<link rel="stylesheet" href="css/componentes.css">
</head>

<body>

	<header class="layout-cabecalho layout-cabecalho--tabela">
		<div class="container">
			<nav class="navegacao  ">
				<a href="menu.jsp"><img src="imagem/logo.png" width="60"
					height="55" alt="Muchachos" /></a>
			</nav>
		</div>
	</header>
 <form method="post" action="carrinhoServlet">
	<div class="container">
	 <h1 class="titulo-formulario">${mensagem}</h1>
		<h1 class="titulo-formulario">Cliente</h1>
         <input type="hidden" name="id"  value="${funcionario.id}">
		<select style="width: 300px;" name="nome">
			<c:forEach var="c" items="${clientes}">
				<option value="${c.id}" id="${c.id}" />${c.id} - ${c.nome}
         </c:forEach>
		</select>
	</div>

	<div class="container">
		<h1 class="titulo-formulario">Consulta de Produto</h1>
	</div>
	<table class="tabela">
		<thead>
			<tr>
				<th>Selecione</th>
				<th>Codigo</th>
				<th>Produto</th>
				<th>preco(un)</th>
				<th>quantitade no estoque</th>
				<th>categoria</th>
				<th>quantidade</th>
				<th>Data</th>
				<th>Total</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${produtos}">
				<tr>
					<td><input type="checkbox" value="${p.id}" id="${p.id}" name="selProduto"></td>
					<td>${p.id}</td>
					<td>${p.nome}</td>
					<td>${p.preco}</td>
					<td>${p.quantidade}</td>
					<td>${p.categoria}</td>
					<td><input type="text" name="qtdItem" max="${r.qtdItem}"min="0" /></td>
					<td><input type="text" name="data" max="${r.data}" min="0" /></td>
					<td><input type="text" name="subTotal" max="${r.subTotal}"min="0" /></td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<div class="grupo-entrada">
							<div style="text-align: center; margin-top: 20px">
								<input type="submit" value="Finalizar Compra" class="botao-tabela">
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="grupo-entrada">
							<div style="text-align: center; margin-top: 20px">
								<input type="reset" value="Cancelar" class="botao-tabela">
							</div>
						</div>
					</div>
				</div>
			</div>
	      </form>
	<footer class="layout-rodape">
		<div class="container">
			<p>&copy; Muchachos. Todos os direitos reservados.</p>
		</div>
	</footer>

</body>
</html>
