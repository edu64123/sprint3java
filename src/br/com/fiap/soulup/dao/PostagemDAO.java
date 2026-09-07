package br.com.fiap.soulup.dao;

import br.com.fiap.soulup.connection.ConnectionFactory;
import br.com.fiap.soulup.models.Postagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {

    private Connection conexao;

    public void cadastrar(Postagem postagem) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "INSERT INTO postagens " +
                            "(id, conteudo, usuario_id) " +
                            "VALUES (?, ?, ?)";

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, postagem.getId());
            ps.setString(2, postagem.getConteudo());
            ps.setInt(3, postagem.getUsuarioId());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Postagem buscarPorId(int id) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        Postagem postagem = new Postagem();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM postagens WHERE id = ?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                postagem.setId(rs.getInt(1));
                postagem.setConteudo(rs.getString(2));
                postagem.setUsuarioId(rs.getInt(3));
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return postagem;
    }

    public List<Postagem> listar() {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        List<Postagem> postagens = new ArrayList<>();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM postagens"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Postagem postagem = new Postagem();

                postagem.setId(rs.getInt(1));
                postagem.setConteudo(rs.getString(2));
                postagem.setUsuarioId(rs.getInt(3));

                postagens.add(postagem);
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return postagens;
    }

    public List<Postagem> listarPorUsuario(int usuarioId) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        List<Postagem> postagens = new ArrayList<>();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM postagens WHERE usuario_id = ?"
            );

            ps.setInt(1, usuarioId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Postagem postagem = new Postagem();

                postagem.setId(rs.getInt(1));
                postagem.setConteudo(rs.getString(2));
                postagem.setUsuarioId(rs.getInt(3));

                postagens.add(postagem);
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return postagens;
    }

    public void alterar(Postagem postagem) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "UPDATE postagens SET conteudo = ? " +
                            "WHERE id = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, postagem.getConteudo());
            ps.setInt(2, postagem.getId());

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
                    "DELETE FROM postagens WHERE id = ?"
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