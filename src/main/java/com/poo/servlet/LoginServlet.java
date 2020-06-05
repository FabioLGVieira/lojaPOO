package com.poo.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poo.dao.FuncionarioDao;
import com.poo.model.Funcionario;

/**
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private FuncionarioDao funcionarioDao = new FuncionarioDao();
    private Funcionario funcionario = new Funcionario();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Logar")) {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            try {
                funcionario = funcionarioDao.validar(nome, senha);
                if (funcionario.getNome() != null && funcionario.getSenha() != null) {
                    request.setAttribute("mensagem", "Bem vindo " + ", " + funcionario.getNome());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("mensagem", "Nome ou senha invalido");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.getMessage();
                System.out.println(e);

            }
        }

    }
}
