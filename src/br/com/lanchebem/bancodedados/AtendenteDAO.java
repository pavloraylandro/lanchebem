package br.com.lanchebem.bancodedados;

import br.com.lanchebem.modelos.Atendente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class AtendenteDAO {

    private Connection connection;

    public AtendenteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionaAtendente(Atendente atendente) {
        String sql = "INSERT INTO `atendentes`( `nome`, `cpf`, `datadenascimento`, `salario`,"
                + " `tipodefuncionario`, `datadecadastro`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getCpf());
            System.out.println("Eu sou a data: " + atendente.getDatadenascimento());
            stmt.setDate(3, new Date(atendente.getDatadenascimento().getTimeInMillis()));
            stmt.setDouble(4, atendente.getSalario());
            stmt.setString(5, atendente.getTipoDeFuncionario());
            stmt.setDate(6, new Date(atendente.getDataDeCadastro().getTimeInMillis()));
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, atendente.getDadosPessoais());
        } catch (SQLException e) {
        }

    }

    public List<Atendente> listeAtendentes() {
        Calendar dataDeNascimento = Calendar.getInstance();
        Calendar dataDeCadastro = Calendar.getInstance();
        List<Atendente> atendentes = new ArrayList<>();
        String sql = "SELECT * FROM `atendentes`";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Atendente atendente = new Atendente();
                atendente.setId(rs.getInt("id"));
                atendente.setNome(rs.getString("nome"));
                atendente.setCpf(rs.getString("cpf"));
                dataDeNascimento.setTime(rs.getDate("datadenascimento"));
                atendente.setDatadenascimento(dataDeNascimento);
                atendente.setSalario(rs.getDouble("salario"));
                atendente.setTipoDeFuncionario(rs.getString("tipodefuncionario"));
                dataDeCadastro.setTime(rs.getDate("datadecadastro"));
                atendente.setDataDeCadastro(dataDeCadastro);
                atendentes.add(atendente);
            }
        } catch (SQLException e) {
        }
        return atendentes;
    }

    public void alteraDadosAtendente(Atendente atendente) {
        String sql = "UPDATE `atendentes` SET"
                + "`nome`=?,`cpf`=?,`datadenascimento`=?,"
                + "`salario`=?,"
                + "`tipodefuncionario`=?,`datadecadastro`=? WHERE id=? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getCpf());
            System.out.println("Eu sou a data: " + atendente.getDatadenascimento());
            stmt.setDate(3, new Date(atendente.getDatadenascimento().getTimeInMillis()));
            stmt.setDouble(4, atendente.getSalario());
            stmt.setString(5, atendente.getTipoDeFuncionario());
            stmt.setDate(6, new Date(atendente.getDataDeCadastro().getTimeInMillis()));
            stmt.setInt(7, atendente.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Atendente alterado");
        } catch (SQLException e) {
        }

    }

    public void removeAtendente(int id) {
        String sql = "DELETE FROM `atendentes` WHERE id =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Atendente Excluido");
        } catch (SQLException e) {
        }
    }

}
