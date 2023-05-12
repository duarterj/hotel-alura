package dao;


import modelo.Hospede;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    private Connection connection;

    public HospedeDAO(Connection connection) {
        this.connection = connection;
    }
    public void salvar(Hospede hospede) {
        try {
            String sql = "INSERT INTO hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, id_reserva) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, hospede.getNome());
                pstm.setString(2, hospede.getSobrenome());
                pstm.setDate(3, hospede.getDataNascimento());
                pstm.setString(4, hospede.getNacionalidade());
                pstm.setString(5, hospede.getTelefone());
                pstm.setInt(6, hospede.getIdReserva());

                pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        hospede.setId(rst.getInt(1));
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Hospede> listarTodosHospedes() {
        List<Hospede> hospedes = new ArrayList<Hospede>();
        try {
            String sql = "SELECT id, nome, sobrenome, data_nascimento, nacionalidade, telefone, id_reserva FROM hospedes";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEmHospede(hospedes, pstm);
            }
            return hospedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hospede> listarHospedePesquisado(String pesquisa) {
        List<Hospede> hospedes = new ArrayList<Hospede>();
        try {
            String sql = "SELECT * FROM HOSPEDES WHERE SOBRENOME=" + "\"" + pesquisa + "\"";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEmHospede(hospedes, pstm);
            }
            return hospedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEmHospede(List<Hospede> hospedes, PreparedStatement pstm) throws SQLException {
        try(ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Hospede hospede = new Hospede(rst.getInt("id"), rst.getString("nome"), rst.getString("sobrenome"), rst.getDate("data_nascimento"), rst.getString("nacionalidade"), rst.getString("telefone"), rst.getInt("id_reserva"));

                hospedes.add(hospede);
            }
        }
    }

    public void alterarHospede(Hospede hospede) {
        try {
            String sql = "UPDATE hospedes set nome=?, sobrenome=?, data_nascimento=?, nacionalidade=?, telefone=? WHERE id=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, hospede.getNome());
                pstm.setString(2, hospede.getSobrenome());
                pstm.setDate(3, hospede.getDataNascimento());
                pstm.setString(4, hospede.getNacionalidade());
                pstm.setString(5, hospede.getTelefone());
                pstm.setInt(6, hospede.getId());

                pstm.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluirHospede(Hospede hospede) {
        try {
            String sql = "DELETE from hospedes WHERE id=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setInt(1, hospede.getId());

                pstm.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

