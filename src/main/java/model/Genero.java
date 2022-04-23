package model;

import java.util.List;

public class Genero {
    private int id;
    private String nome;
    private String descricao;
    private List<Banda> bandaList;

    public Genero() { }

    public Genero(int id) {
        this.id = id;
    }

    public Genero(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Genero(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Banda> getBandaList() {
        return bandaList;
    }

    public void setBandaList(List<Banda> bandaList) {
        this.bandaList = bandaList;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
