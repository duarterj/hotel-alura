package controller;

import dao.ReservaDAO;
import jdbc.factory.ConnectionFactory;
import modelo.Reserva;

import java.sql.Connection;
import java.util.List;

public class ReservasController {

    private ReservaDAO reservaDAO;

    public ReservasController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDAO = new ReservaDAO(connection);
    }

    public void salvar(Reserva reserva)  {this.reservaDAO.salvar(reserva);}

    public void alterar(Reserva reserva) {this.reservaDAO.alterarReserva(reserva);}

    public void excluir(Reserva reserva) {this.reservaDAO.excluirReserva(reserva);}

    public List<Reserva> retornarListaReserva() {return this.reservaDAO.listarTodasReservas();}


    public List<Reserva> retornarListaReservaPesquisado(String pesquisa) {return this.reservaDAO.listarReservaPesquisado(pesquisa);}
}
