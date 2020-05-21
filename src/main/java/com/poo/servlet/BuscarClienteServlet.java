package com.poo.servlet;
/**
 *
 * @author AS Diego Souza de Queiroz
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poo.dao.ClienteDao;
import com.poo.model.Cliente;


@WebServlet("/buscarClienteServlet")
public class BuscarClienteServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
	 

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			List<Cliente> listaCliente = ClienteDao.buscar(request.getParameter("Busca"));
			request.setAttribute("listaCliente", listaCliente);	
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	   }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/buscaCliente.jsp");
		dispatcher.forward(request, response);  
	} 
	

} 