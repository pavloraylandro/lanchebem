package br.com.lanchebem.bancodedados;

import br.com.lanchebem.modelos.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionaCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes( nome, cpf, datadenascimento, "
                + "tipodecliente, datadecadastro) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            System.out.println("Eu sou a data: " + cliente.getDatadenascimento());
            stmt.setDate(3, new Date(cliente.getDatadenascimento().getTimeInMillis()));
            stmt.setString(4, cliente.getTipoDeCliente());
            stmt.setDate(5, new Date(cliente.getDatadecadastro().getTimeInMillis()));
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, cliente.getDadosPessoais());
        } catch (SQLException e) {
        }
    }

    public List<Cliente> listaClientes() {
        Calendar dataDeNascimento = Calendar.getInstance();
        Calendar dataDeCadastro = Calendar.getInstance();
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM `clientes` ORDER BY nome";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                dataDeNascimento.setTime(rs.getDate("datadenascimento"));
                cliente.setDatadenascimento(dataDeNascimento);
                cliente.setTipoDeCliente(rs.getString("tipodecliente"));
                dataDeCadastro.setTime(rs.getDate("datadecadastro"));
                cliente.setDatadecadastro(dataDeCadastro);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
        }
        return clientes;
    }

    public void alteraDadosCliente(Cliente cliente) {
        String sql = "UPDATE `clientes` SET `nome`=?,`cpf`=?,"
                + "`datadenascimento`=?,`tipodecliente`=?,"
                + "`datadecadastro`=? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new Date(cliente.getDatadenascimento().getTimeInMillis()));
            stmt.setString(4, cliente.getTipoDeCliente());
            stmt.setDate(5, new Date(cliente.getDatadecadastro().getTimeInMillis()));
            stmt.setInt(6, cliente.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Dados do Cliente alterados");
        } catch (SQLException e) {
        }
    }

    public void excluiCliente(int id) {
        String sql = "DELETE FROM `clientes` WHERE id =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente Excluido");
        } catch (SQLException e) {
        }

    }

    public List<Cliente> buscaClientesCadastrados(String nome) {
        Calendar dataDeNascimento = Calendar.getInstance();
        Calendar dataDeCadastro = Calendar.getInstance();
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                dataDeNascimento.setTime(rs.getDate("datadenascimento"));
                cliente.setDatadenascimento(dataDeNascimento);
                cliente.setTipoDeCliente(rs.getString("tipodecliente"));
                dataDeCadastro.setTime(rs.getDate("datadecadastro"));
                cliente.setDatadecadastro(dataDeCadastro);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
        }
        return clientes;
    }

}
