package dao;


import modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Reserva reserva) {
        try {
            String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setDate(1, reserva.getDataEntrada());
                pstm.setDate(2, reserva.getDataSaida());
                pstm.setString(3, reserva.getValor());
                pstm.setString(4, reserva.getFormaPagamento());

                pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        reserva.setId(rst.getInt(1));
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    public void alterarReserva(Reserva reserva) {
        try {
            String sql = "UPDATE reservas set data_entrada=?, data_saida=?, valor=?, forma_pagamento=? WHERE id=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setDate(1, reserva.getDataEntrada());
                pstm.setDate(2, reserva.getDataSaida());
                pstm.setString(3, reserva.getValor());
                pstm.setString(4, reserva.getFormaPagamento());
                pstm.setInt(5, reserva.getId());

                pstm.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluirReserva(Reserva reserva) {
        try {
            String sql = "DELETE from reservas WHERE id=?";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setInt(1, reserva.getId());

                pstm.executeUpdate();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public List<Reserva> listarTodasReservas() {
        List<Reserva> reservas = new ArrayList<Reserva>();
        try {
            String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas";
             try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                 pstm.execute();

                 transformarResultSetEmReserva(reservas, pstm);
             }
             return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> listarReservaPesquisado(String pesquisa) {
        List<Reserva> reservas = new ArrayList<Reserva>();
        try {
            String sql = "SELECT * FROM RESERVAS WHERE ID=" + "\"" + pesquisa + "\"";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEmReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEmReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
        try(ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

                reservas.add(reserva);
            }
        }
    }


}




