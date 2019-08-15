
package br.com.lanchebem.bancodedados;

import br.com.lanchebem.modelos.Cardapio;
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

public class CardapioDAO {
    
    private Connection connection;

    public CardapioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionaCardapio(Cardapio cardapio) {
        String sql = "INSERT INTO cardapio( comida, preco) VALUES (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cardapio.getComida());
            stmt.setDouble(2, cardapio.getPreco());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Comida cadastrada");
        } catch (SQLException e) {
        }
    }

    public List<Cardapio> listaCardapio() {
        List<Cardapio> cardapios = new ArrayList<>();
        String sql = "SELECT * FROM `cardapio` ORDER BY comida";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cardapio cardapio = new Cardapio();
                cardapio.setId(rs.getInt("id"));
                cardapio.setComida(rs.getString("comida"));
                cardapio.setPreco(rs.getDouble("preco"));
                cardapios.add(cardapio);
            }
        } catch (SQLException e) {
        }
        return cardapios;
    }

    public void alteraDadosCardapio(Cardapio cardapio) {
        String sql = "update cardapio set comida = ?, preco = ? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cardapio.getComida());
            stmt.setDouble(2, cardapio.getPreco());
            stmt.setInt(3, cardapio.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Comida Alterada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluiCardapio(int id) {
        String sql = "DELETE FROM `cardapio` WHERE id =?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Comida Excluida");
        } catch (SQLException e) {
        }

    }

    public List<Cardapio> buscaComidasCadastrados(String comida) {
        List<Cardapio> cardapios = new ArrayList<>();
        String sql = "SELECT * FROM `cardapio` where comida like ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, comida + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cardapio cardapio = new Cardapio();
                cardapio.setId(rs.getInt("id"));
                cardapio.setComida(rs.getString("comida"));
                cardapio.setPreco(rs.getDouble("preco"));
                cardapios.add(cardapio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardapios;
    }
}
