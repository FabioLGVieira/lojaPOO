/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.servlet;

import com.poo.dao.FuncionarioDao;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "GerenciarFuncionarioServlet", urlPatterns = {"/gerenciarFuncionarioServlet"})
public class GerenciarFuncionarioServlet extends HttpServlet {

private final FuncionarioDao funcionarioDao = new FuncionarioDao(); 
	private static final long serialVersionUID = 1L;
       
    
    public GerenciarFuncionarioServlet() {
        super();
    }

	
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao"); 
		String id = request.getParameter("id");
		try {
			if(acao != null && acao.equals("Excluir")) {  
				Integer cod = Integer.parseInt(id);
				funcionarioDao.excluir(cod);
				request.setAttribute("mensagem", "Funcionario Excluido com sucesso!!");
			}
			request.setAttribute("funcionarios", funcionarioDao.getFuncionario1());
			
		} catch (SQLException e) {
			request.setAttribute("mensagem","Erro de banco de dados");
			
		} catch (ClassNotFoundException e) {
			
			request.setAttribute("mensagem", "Erro de driver");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/gerenciarFuncionario.jsp");
	    dispatcher.forward(request, response);
	}
}