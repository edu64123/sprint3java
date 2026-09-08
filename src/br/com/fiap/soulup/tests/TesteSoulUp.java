package br.com.fiap.soulup.tests;

import br.com.fiap.soulup.dao.BilheteUnicoDAO;
import br.com.fiap.soulup.dao.MissaoDAO;
import br.com.fiap.soulup.dao.PostagemDAO;
import br.com.fiap.soulup.dao.UsuarioDAO;
import br.com.fiap.soulup.models.BilheteUnico;
import br.com.fiap.soulup.models.Missao;
import br.com.fiap.soulup.models.Postagem;
import br.com.fiap.soulup.models.Usuario;

public class TesteSoulUp {

    public static void main(String[] args) {

        Usuario usuario = new Usuario(
                "eduardo",
                "123456"
        );

        usuario.setId(10);

        usuario.adicionarPontos(500);

        System.out.println(usuario);

        System.out.println(
                "Pode resgatar 300 pontos? " +
                        usuario.podeResgatar(300)
        );

        usuario.gastarPontos(300);

        System.out.println(usuario);

        BilheteUnico bilhete =
                new BilheteUnico(usuario.getId());

        bilhete.setId(10);

        bilhete.adicionarSaldo(50);

        bilhete.adicionarPassagem();

        System.out.println(bilhete);

        Postagem postagem =
                new Postagem(
                        "Hoje participei de uma ação sustentável!",
                        usuario.getId()
                );

        postagem.setId(10);

        System.out.println(postagem);

        System.out.println(
                "Postagem válida? " +
                        postagem.validarConteudo()
        );

        Missao missao =
                new Missao(
                        10,
                        "Participar de uma ação sustentável",
                        500
                );

        System.out.println(missao);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PostagemDAO postagemDAO = new PostagemDAO();
        BilheteUnicoDAO bilheteDAO = new BilheteUnicoDAO();
        MissaoDAO missaoDAO = new MissaoDAO();

        bilheteDAO.excluir(10);
        postagemDAO.excluir(10);
        usuarioDAO.excluir(10);
        missaoDAO.excluir(10);

        usuarioDAO.cadastrar(usuario);

        postagemDAO.cadastrar(postagem);

        bilheteDAO.cadastrar(bilhete);

        missaoDAO.cadastrar(missao);

        System.out.println("Dados cadastrados no banco!");

        System.out.println(
                usuarioDAO.buscarPorUsername("eduardo")
        );

        System.out.println(
                postagemDAO.buscarPorId(10)
        );

        System.out.println(
                bilheteDAO.buscarPorUsuario(10)
        );

        System.out.println(
                missaoDAO.buscarPorId(10)
        );
    }
}