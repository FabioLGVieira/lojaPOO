package com.poo.dao;

import com.poo.db.ConexaoDatabase;
import com.poo.model.Cliente;
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
 *
 * @author Fabio
 */
public class VendaDao {

    public List<Venda> getVenda() throws SQLException, ClassNotFoundException {

        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement(
                "SELECT p.idProduto, p.nome, p.preco, p.quantidade, v.idVenda, v.data, v.pagamento, v.parcela, v.subTotal, c.idCliente FROM Venda as v"
                + " join cadastroProduto as p" + " on p.idProduto = v.idProduto" + " join cadastroCliente as c"
                + " on c.idCliente = v.idCliente");

        ResultSet rs = ps.executeQuery();
        List<Venda> vendas = new ArrayList<>();

        while (rs.next()) {
            vendas.add(new Venda(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5),
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getFloat(9), rs.getInt(10)));

        }

        return vendas;
    }

    public void salvar(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " insert into vendas (idVenda, data, pagamento,parcela subTotal,idcliente,idFuncionario,idProduto)  values (?,?,?,?,?,?,?,?)");

        statement.setInt(1, venda.getIdVenda());
        statement.setString(2, venda.getData());
        statement.setString(3, venda.getPagamento());
        statement.setString(4, venda.getParcelamento());
        statement.setFloat(5, venda.getSubTotal());
        statement.setInt(6, venda.getIdCliente());
        statement.setInt(7, venda.getIdFuncionario());
        statement.setInt(8, venda.getId());
        statement.execute();

    }

    public static List<Venda> buscar(String busca) throws SQLException, Exception {
        String sql = "SELECT p.idProduto, p.nome, p.preco, p.quantidade, v.idVenda, v.data, v.pagamento,v.parcela, v.subTotal,v.idCliente FROM Venda as v "
                + " join cadastroProduto as p" 
                + " on p.idProduto = v.idProduto" 
                + " join cadastroCliente as c"
                + " on c.id = v.idCliente"
                + " join cadastroFuncionario as f" + " on f.id = v.idFuncionario"
                + " WHERE upper(p.nome) like ? ";

        busca = '%' + busca + '%';

        List<Venda> listaVenda = null;

        Connection conexao = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);
            
            ps.setString(1, busca.toUpperCase());
            rs = ps.executeQuery();

            while (rs.next()) {
                if (listaVenda == null) {
                    listaVenda = new ArrayList<>();
                }
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade = rs.getInt("quantidade");
                int idVenda = rs.getInt("idVenda");
                String data = rs.getString("data");
                String pagamento = rs.getString("pagamento");
                String parcela = rs.getString("parcela");
                float subTotal = rs.getFloat("subTotal");
                int idCliente = rs.getInt("idCliente");

                Venda V = new Venda(idProduto, nome, preco, quantidade, idVenda, data, pagamento, parcela, subTotal, idCliente);
                listaVenda.add(V);
            }

        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e);

        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaVenda;
    }

    public static List<Cliente> obterCliente(int id) throws SQLException, Exception {

        String sql = "SELECT * FROM cadastrocliente";

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);

            if (id == 0) {
                rs = ps.executeQuery();
            } else {
                sql += " WHERE ID =?";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
            }

            // Executa a consulta SQL no banco de dados
            List<Cliente> clientes = new ArrayList<Cliente>();

            // Verifica se há pelo menos um resultado
            while (rs.next()) {
                // Cria uma instância de Usuario e popula com os valores do BD

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                clientes.add(cliente);
                // Retorna o resultado
            }

            return clientes;

        } finally {
            // Se o result ainda estiver aberto, realiza seu fechamento
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            // Se o statement ainda estiver aberto, realiza seu fechamento
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            // Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }

    public static List<Produto> obterProduto() throws SQLException, Exception {
        // Compõe uma String de consulta que considera apenas o produto
        String sql = "SELECT * FROM cadastroProduto";

        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);

            // Executa a consulta SQL no banco de dados
            rs = ps.executeQuery();
            List<Produto> produtos = new ArrayList<Produto>();

            // Verifica se há pelo menos um resultado
            while (rs.next()) {
                // Cria uma instância de Produto e popula com os valores do BD

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setQtdItem(rs.getInt("qtdItem"));
                produtos.add(produto);
                // Retorna o resultado
            }

            return produtos;

        } finally {
            // Se o result ainda estiver aberto, realiza seu fechamento
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            // Se o statement ainda estiver aberto, realiza seu fechamento
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            // Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }

    }
}
