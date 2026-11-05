package br.com.agenda.modelo.dao;

//DAO > Data Acess Object

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaDeConexao {

    private static final String URL = "jdbc:sqlite:agenda.db"; //Endereço do banco de dados

    public static Connection abrirConexao(){

        Connection con = null;

        try{
            con = DriverManager.getConnection(URL);
            criarTabela(con);

        }catch (SQLException e){
            System.out.println("Falha ao abrir a conexão: " + e.getMessage());
        }
        return con;
    }

    private static void criarTabela(Connection con){
        String sql = """
                     CREATE TABLE IF NOT EXISTS contatos(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        nome TEXT NOT NULL,
                        telefone TEXT,
                        email TEXT NOT NULL UNIQUE
                     );
                     """;

        // executar comandos dentro do banco de dados
        try(Statement stmt = con.createStatement()){
            stmt.execute(sql);

        }catch (SQLException e){
            System.out.println("Falha ao criar a tabela: " + e.getMessage());
        }
    }

}