package org.senai;

import org.senai.dao.PessoaDAO;
import org.senai.dao.ProfessorDAO;
import org.senai.dao.EstudanteDAO;
import org.senai.model.Pessoa;
import org.senai.model.Professor;
import org.senai.model.Estudante;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Instanciação dos DAOs
        PessoaDAO pessoaDAO = new PessoaDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        EstudanteDAO estudanteDAO = null;

        try {
            estudanteDAO = new EstudanteDAO();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }

        // Inserindo pessoas
        Pessoa[] pessoas = {
                new Pessoa(0, "João Silva", "joao.silva@email.com"),
                new Pessoa(0, "Maria Oliveira", "maria.oliveira@email.com"),
                new Pessoa(0, "Carlos Pereira", "carlos.pereira@email.com"),
                new Pessoa(0, "Ana Costa", "ana.costa@email.com"),
                new Pessoa(0, "Lucas Mendes", "lucas.mendes@email.com"),
                new Pessoa(0, "Fernanda Lima", "fernanda.lima@email.com"),
                new Pessoa(0, "Ricardo Almeida", "ricardo.almeida@email.com"),
                new Pessoa(0, "Juliana Costa", "juliana.costa@email.com"),
                new Pessoa(0, "Fernando Santos", "fernando.santos@email.com"),
                new Pessoa(0, "Beatriz Lima", "beatriz.lima@email.com")
        };

        // Inserindo as pessoas e obtendo os IDs gerados
        for (Pessoa pessoa : pessoas) {
            pessoaDAO.inserir(pessoa);
        }

        // Recuperando os registros de pessoas para associar a professores e estudantes
        Pessoa pessoa1 = pessoaDAO.buscarPorId(1);
        Pessoa pessoa2 = pessoaDAO.buscarPorId(2);
        Pessoa pessoa3 = pessoaDAO.buscarPorId(3);
        Pessoa pessoa4 = pessoaDAO.buscarPorId(4);
        Pessoa pessoa5 = pessoaDAO.buscarPorId(5);
        Pessoa pessoa6 = pessoaDAO.buscarPorId(6);
        Pessoa pessoa7 = pessoaDAO.buscarPorId(7);
        Pessoa pessoa8 = pessoaDAO.buscarPorId(8);
        Pessoa pessoa9 = pessoaDAO.buscarPorId(9);
        Pessoa pessoa10 = pessoaDAO.buscarPorId(10);

        // Inserindo professores
        Professor[] professores = {
                new Professor(pessoa1.getId(), "Matemática"),
                new Professor(pessoa3.getId(), "História"),
                new Professor(pessoa5.getId(), "Física"),
                new Professor(pessoa7.getId(), "Química"),
                new Professor(pessoa9.getId(), "Biologia")
        };

        for (Professor professor : professores) {
            professorDAO.inserir(professor);
        }

        // Inserindo estudantes
        Estudante[] estudantes = {
                new Estudante(pessoa2.getId(), "2023001"),
                new Estudante(pessoa4.getId(), "2023002"),
                new Estudante(pessoa6.getId(), "2023003"),
                new Estudante(pessoa8.getId(), "2023004"),
                new Estudante(pessoa10.getId(), "2023005")
        };

        for (Estudante estudante : estudantes) {
            estudanteDAO.inserir(estudante);
        }

        System.out.println("Dados inseridos com sucesso!");
    }
}

// Main para Listar Estudantes
/*
package org.senai;

import org.senai.dao.EstudanteDAO;
import org.senai.model.Estudante;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstudanteDAO estudanteDAO = null;
        try {
            estudanteDAO = new EstudanteDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Listar todos os estudantes
        List<Estudante> estudantes = estudanteDAO.listarTodos();
        System.out.println("Lista de Estudantes:");
        for (Estudante estudante : estudantes) {
            System.out.println("ID: " + estudante.getPessoaId() + ", Matrícula: " + estudante.getMatricula());
        }
    }
}
*/
