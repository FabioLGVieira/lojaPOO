package com.poo.servlet;

import com.poo.dao.ClienteDao;
import com.poo.dao.ProdutoDao;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 15/05/2020 21:04
 *
 * @author Fabio
 */
@WebServlet("/vendaServlet")
public class VendaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProdutoDao produtoDao = new ProdutoDao();
    private ClienteDao clienteDao = new ClienteDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("produtos", produtoDao.getProduto1());
            request.setAttribute("clientes", clienteDao.getCliente1());

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados");

        } catch (ClassNotFoundException e) {

            request.setAttribute("mensagem", "Erro de driver");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
    }

}
