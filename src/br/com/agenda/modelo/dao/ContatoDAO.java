package br.com.agenda.modelo.dao;

import br.com.agenda.modelo.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    //CRUD (Create, Read, Update, Delete)
    public void gravar (Contato contato) throws SQLException {
        //SQL INJECTION (VALUES) - para evitar ataques, não passa os valores diretamente
        String sql = """
                     INSERT INTO contatos (nome, telefone, email)
                     VALUES (?,?,?);
                     """;

        try(Connection con = FabricaDeConexao.abrirConexao();
            PreparedStatement stmt = con.prepareStatement(sql);){
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getTelefone());
            stmt.setString(3,contato.getEmail());
            stmt.executeUpdate();

        }catch (SQLException e){
            System.out.println("Falha ao gravar: " + e.getMessage());
        }
    }

}
