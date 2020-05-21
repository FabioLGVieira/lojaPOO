/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.servlet;

import com.poo.dao.ProdutoDao;
import com.poo.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valter Lafuente Junior
 */
@WebServlet(name = "buscarProdutoServlet", urlPatterns = {"/buscarProdutoServlet"})
public class BuscarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
	    List<Produto> listaProduto = ProdutoDao.buscar(request.getParameter("Busca"));
	    request.setAttribute("listaProduto", listaProduto);	
			
	} catch (Exception e) {
	   request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	}
	   RequestDispatcher dispatcher = request.getRequestDispatcher("/buscaProduto.jsp");
  	   dispatcher.forward(request, response);
	}
} 
		
