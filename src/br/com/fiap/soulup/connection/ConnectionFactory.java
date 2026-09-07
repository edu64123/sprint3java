package br.com.fiap.soulup.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static String usuario = "RM570916";
    private static String senha = "270406";

    public static Connection getConnection() {

        Connection conexao = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            conexao = DriverManager.getConnection(
                    url,
                    usuario,
                    senha
            );

        } catch (ClassNotFoundException e) {

            System.out.println("Driver do Oracle não encontrado.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Erro ao conectar no banco de dados.");
            e.printStackTrace();
        }

        return conexao;
    }

    public static void closeConnection(Connection conexao) {

        try {

            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {

            System.out.println("Erro ao fechar a conexão.");
            e.printStackTrace();
        }
    }
}