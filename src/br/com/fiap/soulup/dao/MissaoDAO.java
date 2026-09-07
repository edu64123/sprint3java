package br.com.fiap.soulup.dao;

import br.com.fiap.soulup.connection.ConnectionFactory;
import br.com.fiap.soulup.models.Missao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MissaoDAO {

    private Connection conexao;

    public void cadastrar(Missao missao) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "INSERT INTO missoes " +
                            "(id, descricao, recompensa_pontos) " +
                            "VALUES (?, ?, ?)";

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, missao.getId());
            ps.setString(2, missao.getDescricao());
            ps.setInt(3, missao.getRecompensaPontos());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Missao buscarPorId(int id) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        Missao missao = new Missao();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM missoes WHERE id = ?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                missao.setId(rs.getInt(1));
                missao.setDescricao(rs.getString(2));
                missao.setRecompensaPontos(rs.getInt(3));
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return missao;
    }

    public List<Missao> listar() {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        List<Missao> missoes = new ArrayList<>();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM missoes"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Missao missao = new Missao();

                missao.setId(rs.getInt(1));
                missao.setDescricao(rs.getString(2));
                missao.setRecompensaPontos(rs.getInt(3));

                missoes.add(missao);
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return missoes;
    }

    public void alterar(Missao missao) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "UPDATE missoes " +
                            "SET descricao = ?, recompensa_pontos = ? " +
                            "WHERE id = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, missao.getDescricao());
            ps.setInt(2, missao.getRecompensaPontos());
            ps.setInt(3, missao.getId());

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
                    "DELETE FROM missoes WHERE id = ?"
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