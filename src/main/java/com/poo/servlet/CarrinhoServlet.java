package com.poo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poo.dao.VendaDao;
import com.poo.model.Cliente;
import com.poo.model.Venda;

/**
 * Servlet implementation class CarrinhoServlet
 */
@WebServlet("/carrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	  private final VendaDao vendaDao = new VendaDao();
	private static final long serialVersionUID = 1L;
    
	    @Override
	    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	        
	        String CodCliente = request.getParameter("cliente");
	        String [] idProduto = request.getParameterValues("selProduto");
	        String qtdItem = request.getParameter("qtdItem");
	        String data = request.getParameter("data");
	        String subTotal = request.getParameter("subtotal");
	        
	        int qtd = Integer.parseInt(qtdItem);
	        int idCliente = Integer.parseInt(CodCliente);
	        List<Cliente> cliente = new ArrayList<>();
	        float total = Float.parseFloat(subTotal);
	        try {
	           cliente = VendaDao.obterCliente(idCliente);
	        } catch (Exception e) {
                     System.out.println(e);
	        }
	                
	        request.setAttribute("cliente", cliente);
	        request.setAttribute("produto", idProduto);
	        request.setAttribute("quantidade", qtd);
	        request.setAttribute("data", data);
	        request.setAttribute("subTotal", total);
	        
	        request.getRequestDispatcher("WEB-INF/paginas/venda.jsp")
	                .forward(request, response);            
	    }

          @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data = request.getParameter("data");
		String pagamento = request.getParameter("pagamento");
		String parcelamento = request.getParameter("parcelamento");
		float subTotal = Float.parseFloat(request.getParameter("subTotal"));
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		int idFuncionario = Integer.parseInt(request.getParameter("idFuncionario"));
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		
		Venda venda = new Venda(idProduto,3,data,pagamento,parcelamento,subTotal,idCliente,idFuncionario);
		
	try {
		if(venda.getIdVenda() == null) {
		 vendaDao.salvar(venda);
		 request.setAttribute("mensagem","Venda finalizada com sucesso!!!");
		 
		} else {
			 request.setAttribute("mensagem","Venda J� efetuada!!!");
			
		}
	  } catch (SQLException e) {
		System.out.println("oi");
		request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
		 request.setAttribute("venda", venda);
	
		 
    } catch (ClassNotFoundException e) {
            System.out.println(e);
	}
  }
}
  
