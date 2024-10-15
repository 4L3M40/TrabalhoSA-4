package org.senai.dao;

import org.senai.model.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IDAO<Professor> {
    private Connection conn;

    public ProfessorDAO() {
        try {
            this.conn = Conexao.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void inserir(Professor professor) {
        String sql = "INSERT INTO professores (pessoa_id, departamento) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professor.getPessoaId());
            stmt.setString(2, professor.getDepartamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Professor professor) {
        String sql = "UPDATE professores SET departamento = ? WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professor.getDepartamento());
            stmt.setInt(2, professor.getPessoaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM professores WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professor buscarPorId(int id) {
        String sql = "SELECT * FROM professores WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Professor(rs.getInt("pessoa_id"), rs.getString("departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professores";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                professores.add(new Professor(rs.getInt("pessoa_id"), rs.getString("departamento")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }
}