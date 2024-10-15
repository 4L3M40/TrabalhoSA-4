package org.senai.dao;

import org.senai.model.Estudante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO implements IDAO<Estudante> {
    private Connection conn;

    public EstudanteDAO() throws SQLException {
        this.conn = Conexao.getConnection();
    }

    @Override
    public void inserir(Estudante estudante) {
        String sql = "INSERT INTO estudantes (pessoa_id, matricula) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, estudante.getPessoaId());
            stmt.setString(2, estudante.getMatricula());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Estudante estudante) {
        String sql = "UPDATE estudantes SET matricula = ? WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estudante.getMatricula());
            stmt.setInt(2, estudante.getPessoaId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM estudantes WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudante buscarPorId(int id) {
        String sql = "SELECT * FROM estudantes WHERE pessoa_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudante(rs.getInt("pessoa_id"), rs.getString("matricula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudante> listarTodos() {
        List<Estudante> estudantes = new ArrayList<>();
        String sql = "SELECT * FROM estudantes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estudantes.add(new Estudante(rs.getInt("pessoa_id"), rs.getString("matricula")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }
}