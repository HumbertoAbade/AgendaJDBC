package br.com.agenda.modelo.testes;

import br.com.agenda.modelo.Contato;
import br.com.agenda.modelo.dao.ContatoDAO;

import java.sql.SQLException;

public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato();
        contato.setNome("Juca");
        contato.setTelefone("21987654321");
        contato.setEmail("juca@email.com");

        ContatoDAO dao = new ContatoDAO();
        dao.gravar(contato);
        System.out.println("Contato gavado com sucesso.");

    }
}
