package com.poo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poo.dao.ProdutoDao;

/**
 * 15/05/2020 21:00
 * @author Fabio
 */
@WebServlet("/gerenciarProdutoServlet")
public class GerenciarProdutoServlet extends HttpServlet {
	
	private ProdutoDao produtoDao = new ProdutoDao();
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		try {
			if(acao != null && acao.equals("Excluir")) { 
				Integer cod = Integer.parseInt(id);
				produtoDao.excluir(cod);
				request.setAttribute("mensagem", "Produto Excluido com sucesso!!");
			}
			request.setAttribute("produtos", produtoDao.getProduto1());
			
		} catch (SQLException e) {
			request.setAttribute("mensagem","Erro de banco de dados");
			
		} catch (ClassNotFoundException e) {
			
			request.setAttribute("mensagem", "Erro de driver");
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gerenciarProduto.jsp");
	    dispatcher.forward(request, response);
	}

}
