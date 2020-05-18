package com.poo.dao;

import com.poo.db.ConexaoDatabase;
import com.poo.model.Produto;
import com.poo.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 15/05/2020 21:15
 * @author Fabio
 */

public class VendaDao {

	public List<Venda> getVenda() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoDatabase.getConexao();
		

		return null;
	}

	public void salvar(Venda venda) throws ClassNotFoundException, SQLException {
		

	}

	public static List<Venda> buscar(String busca) throws SQLException, Exception {
		
		return null;
	}

	public static List<Cliente> obterCliente(int id) throws SQLException, Exception {

return null;
	}

	public static List<Produto> obterProduto() throws SQLException, Exception {
		
			return null;
        }
}
