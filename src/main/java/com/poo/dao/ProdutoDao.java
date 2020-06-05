package com.poo.dao;

import com.poo.db.ConexaoDatabase;
import com.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valter Lafuente Junior
 */
public class ProdutoDao {

    public List<Produto> getProduto() throws SQLException, ClassNotFoundException {

        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT idProduto,nome,preco,quantidade,descricao,categoria,situacao FROM cadastroProduto");

        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList<>();

        while (rs.next()) {
            produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
        }

        return produtos;
    }

    public void salvar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " insert into cadastroProduto(nome, preco,quantidade,descricao,categoria,situacao)"
                + " values (?,?,?,?,?,?)");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getSituacao());
        statement.execute();
    }

    public List<Produto> getProduto1() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Select idProduto, nome, preco, quantidade, categoria from cadastroProduto");

        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList<>();

        while (rs.next()) {
            produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5)));
        }

        return produtos;

    }

    public void excluir(Integer cod) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                "DELETE FROM cadastroProduto WHERE idProduto = ?");

        statement.setInt(1, cod);
        statement.execute();
    }

    public Produto getProdutoId(Integer cod) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT idProduto, nome, preco,quantidade,descricao,categoria,situacao FROM cadastroProduto WHERE idProduto=?");
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
                    rs.getString(5), rs.getString(6), rs.getString(7));
        }

        throw new SQLException("Codigo não encontrado: " + cod);
    }

    public void atualizar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " UPDATE cadastroProduto SET nome=?, preco=?, quantidade=?, descricao=?, categoria=?, situacao=? WHERE idProduto=?");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getSituacao());
        statement.setInt(7, produto.getId());
        statement.execute();

    }

    public static List<Produto> buscar(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM cadastroProduto WHERE  upper(nome) like ? or upper(categoria) like ?";
        busca = '%' + busca + '%';

        List<Produto> listaProduto = null;

        Connection conexao = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, busca.toUpperCase());
            ps.setString(2, busca.toUpperCase());

            rs = ps.executeQuery();

            while (rs.next()) {
                if (listaProduto == null) {
                    listaProduto = new ArrayList<>();
                }
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");

                Produto P = new Produto(idProduto, nome, preco, quantidade, categoria);
                listaProduto.add(P);
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
        return listaProduto;
    }
}
