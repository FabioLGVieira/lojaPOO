package com.poo.dao;

/**
 *
 * @author AS Diego Souza de Queiroz
 */
import com.poo.db.ConexaoDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.poo.model.Cliente;

public class ClienteDao {

    public List<Cliente> getCliente() throws SQLException, ClassNotFoundException {

        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, Cpf, Rg, Sexo,"
                + "estadoCivil, dataNascimento, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
                + "Email, situacao FROM cadastroCliente");

        ResultSet rs = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();

        while (rs.next()) {
            clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16)));
        }

        return clientes;
    }

    public void salvar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " insert into cadastroCliente(nome, cpf, rg, sexo, estadoCivil, dataNascimento, estado, cidade, bairro,  logradouro,"
                + " numero,complemento, telefone,email, situacao)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCpf());
        statement.setString(3, cliente.getRg());
        statement.setString(4, cliente.getSexo());
        statement.setString(5, cliente.getEstadoCivil());
        statement.setString(6, cliente.getDataNascimento());
        statement.setString(7, cliente.getEstado());
        statement.setString(8, cliente.getCidade());
        statement.setString(9, cliente.getBairro());
        statement.setString(10, cliente.getLogradouro());
        statement.setInt(11, cliente.getNumero());
        statement.setString(12, cliente.getComplemento());
        statement.setString(13, cliente.getTelefone());
        statement.setString(14, cliente.getEmail());
        statement.setString(15, cliente.getSituacao());

        statement.execute();
    }

    public List<Cliente> getCliente1() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Select id, nome, cpf, telefone, email, situacao from cadastroCliente");

        ResultSet rs = ps.executeQuery();
        List<Cliente> clientes = new ArrayList<>();

        while (rs.next()) {
            clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getString(6)));
        }

        return clientes;

    }

    public void excluir(Integer cod) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                "DELETE FROM cadastroCliente WHERE id = ?");

        statement.setInt(1, cod);
        statement.execute();
    }

    public Cliente getClienteId(Integer cod) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, Cpf, Rg, Sexo,"
                + "estadoCivil, dataNascimento, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
                + "Email, Situacao FROM cadastroCliente WHERE id=?");
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16));
        }

        throw new SQLException("Codigo não encontrado: " + cod);
    }

    public void atualizar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " UPDATE cadastroCliente SET nome=?, cpf=?, rg=?, sexo=?, estadoCivil=?, dataNascimento=?, estado=?, cidade=?, bairro=?,  logradouro=?,"
                + " numero=?,complemento=?, telefone=?,email=?, situacao=? WHERE id=?");

        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCpf());
        statement.setString(3, cliente.getRg());
        statement.setString(4, cliente.getSexo());
        statement.setString(5, cliente.getEstadoCivil());
        statement.setString(6, cliente.getDataNascimento());
        statement.setString(7, cliente.getEstado());
        statement.setString(8, cliente.getCidade());
        statement.setString(9, cliente.getBairro());
        statement.setString(10, cliente.getLogradouro());
        statement.setInt(11, cliente.getNumero());
        statement.setString(12, cliente.getComplemento());
        statement.setString(13, cliente.getTelefone());
        statement.setString(14, cliente.getEmail());
        statement.setString(15, cliente.getSituacao());
        statement.setInt(16, cliente.getId());
        statement.execute();

    }

    public static List<Cliente> buscar(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM cadastroCliente WHERE  upper(nome) like ? or upper(cpf) like ?";
        busca = '%' + busca + '%';

        List<Cliente> listaCliente = null;

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
                if (listaCliente == null) {
                    listaCliente = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String situacao = rs.getString("situacao");

                Cliente C = new Cliente(id, nome, cpf, telefone, email, situacao);
                listaCliente.add(C);
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
        return listaCliente;
    }
}
