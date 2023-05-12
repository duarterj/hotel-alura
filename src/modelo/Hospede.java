package modelo;

import java.sql.Date;

public class Hospede {

    private Integer id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String nacionalidade;
    private String telefone;
    private Integer idReserva;

    public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer idReserva) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.idReserva = idReserva;
    }

    public Hospede(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer idReserva) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.idReserva = idReserva;
    }

    public Hospede(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }
}
