package br.com.agenda.modelo.testes;

import br.com.agenda.modelo.Contato;
import br.com.agenda.modelo.dao.FabricaDeConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        FabricaDeConexao.abrirConexao();
        System.out.println("Conectado ao banco de dados.");
        //A conexão sempre deve ser fechada
        FabricaDeConexao.abrirConexao().close();

        //Try with resources > fecha a conexão automaticamente
        //try(Connection con = FabricaDeConexao.abrirConexao();){
        //    System.out.println("Conectado ao banco de dados.");
        //}catch (SQLException e){
        //    System.out.println("Falha ao abrir a conexão: " + e.getMessage());
        //}

        System.out.println("Encerrando a conexão.");
    }
}
