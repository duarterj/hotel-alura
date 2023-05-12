package controller;

import dao.HospedeDAO;
import jdbc.factory.ConnectionFactory;
import modelo.Hospede;


import java.sql.Connection;
import java.util.List;

public class HospedesController {

    private HospedeDAO hospedeDAO;

    public HospedesController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.hospedeDAO = new HospedeDAO(connection);
    }

    public List<Hospede> retornarListaHospedes() {return this.hospedeDAO.listarTodosHospedes();}
    public void salvar(Hospede hospede)  {this.hospedeDAO.salvar(hospede);}
    public void alterar(Hospede hospede)  {this.hospedeDAO.alterarHospede(hospede);}
    public void excluir(Hospede hospede) {this.hospedeDAO.excluirHospede(hospede);}
    public List<Hospede> retornarListaHospedePesquisado(String pesquisa) {return this.hospedeDAO.listarHospedePesquisado(pesquisa);}
}
