package com.poo.servlet;

import com.poo.dao.VendaDao;
import com.poo.model.Venda;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 22/05/2020 16:04
 *
 * @author Fabio
 */
@WebServlet("/buscarVendaServlet")
public class BuscarVendaServlet extends HttpServlet {

    VendaDao vendaDao = new VendaDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Venda> listaVenda = VendaDao.buscar(request.getParameter("Busca"));
            request.setAttribute("listaVenda", listaVenda);

        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/RelatorioVendas.jsp");
        dispatcher.forward(request, response);
    }

}
