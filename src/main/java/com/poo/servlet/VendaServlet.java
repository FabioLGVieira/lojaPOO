package com.poo.servlet;

import com.poo.dao.ClienteDao;
import com.poo.dao.ProdutoDao;
import com.poo.dao.VendaDao;
import com.poo.model.Cliente;
import com.poo.model.Produto;
import com.poo.model.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet", "/vendaServlet"})
public class VendaServlet extends HttpServlet {

    private ProdutoDao produtoDao = new ProdutoDao();
    private ClienteDao clienteDao = new ClienteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Produto> produtos = produtoDao.getProduto();
            List<Cliente> clientes = clienteDao.getCliente();
            request.setAttribute("produtos", produtos);
            request.setAttribute("clientes", clientes);

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/novaVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCliente = Integer.parseInt(request.getParameter("nome"));
        String itens[] = request.getParameterValues("tabelaProdutos");
        // compra
        for (int i = 0; i < itens.length; i++) {
            if (itens[i].equals(".")) {
                //adiciona na compra}
            }

            Date d = new Timestamp(System.currentTimeMillis());
            String data = d.toString();
            Venda venda = new Venda();

            try {
                VendaDao vendaDao = new VendaDao();
                vendaDao.salvar(venda);

            } catch (SQLException e) {

                request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

            } catch (ClassNotFoundException e) {
                request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/novaVenda.jsp");
            dispatcher.forward(request, response);

        }
    }

}
