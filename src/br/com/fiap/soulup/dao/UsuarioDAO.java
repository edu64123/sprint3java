package br.com.fiap.soulup.dao;

import br.com.fiap.soulup.connection.ConnectionFactory;
import br.com.fiap.soulup.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conexao;

    public void cadastrar(Usuario usuario) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql = "INSERT INTO usuarios " +
                    "(id, username, senha, pontos) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getPontos());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public Usuario buscarPorUsername(String username) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        Usuario usuario = new Usuario();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM usuarios WHERE username = ?"
            );

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                usuario.setId(rs.getInt(1));
                usuario.setUsername(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setPontos(rs.getInt(4));
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return usuario;
    }

    public List<Usuario> listar() {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {

            ps = conexao.prepareStatement(
                    "SELECT * FROM usuarios"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt(1));
                usuario.setUsername(rs.getString(2));
                usuario.setSenha(rs.getString(3));
                usuario.setPontos(rs.getInt(4));

                usuarios.add(usuario);
            }

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return usuarios;
    }

    public void alterarUsername(Usuario usuario) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "UPDATE usuarios SET username = ? WHERE id = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, usuario.getUsername());
            ps.setInt(2, usuario.getId());

            ps.executeUpdate();

            ps.close();
            conexao.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void alterarPontos(Usuario usuario) {

        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        try {

            String sql =
                    "UPDATE usuarios SET pontos = ? WHERE id = ?";

            ps = conexao.prepareStatement(sql);

            ps.setInt(1, usuario.getPontos());
            ps.setInt(2, usuario.getId());

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
                    "DELETE FROM usuarios WHERE id = ?"
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