package br.com.fiap.soulup.dao;

import br.com.fiap.soulup.connection.ConnectionFactory;
import br.com.fiap.soulup.models.BilheteUnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilheteUnicoDAO {

    private Connection conexao;

    public void cadastrar(BilheteUnico bilhete) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "INSERT INTO bilhete_unico " +
                            "(id, usuario_id, saldo_dinheiro, passagens, vales_desconto) " +
                            "VALUES (?, ?, ?, ?, ?)";

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, bilhete.getId());
            ps.setInt(2, bilhete.getUsuarioId());
            ps.setDouble(3, bilhete.getSaldoDinheiro());
            ps.setInt(4, bilhete.getPassagens());
            ps.setInt(5, bilhete.getValesDesconto());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public BilheteUnico buscarPorUsuario(int usuarioId) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        BilheteUnico bilhete = new BilheteUnico();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM bilhete_unico WHERE usuario_id = ?"
            );

            ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bilhete.setId(rs.getInt(1));
                bilhete.setUsuarioId(rs.getInt(2));
                bilhete.setSaldoDinheiro(rs.getDouble(3));
                bilhete.setPassagens(rs.getInt(4));
                bilhete.setValesDesconto(rs.getInt(5));
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return bilhete;
    }

    public void alterar(BilheteUnico bilhete) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "UPDATE bilhete_unico " +
                            "SET saldo_dinheiro = ?, " +
                            "passagens = ?, " +
                            "vales_desconto = ? " +
                            "WHERE usuario_id = ?";

            ps = conexao.prepareStatement(sql);

            ps.setDouble(1, bilhete.getSaldoDinheiro());
            ps.setInt(2, bilhete.getPassagens());
            ps.setInt(3, bilhete.getValesDesconto());
            ps.setInt(4, bilhete.getUsuarioId());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            ps = conexao.prepareStatement(
                    "DELETE FROM bilhete_unico WHERE id = ?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}