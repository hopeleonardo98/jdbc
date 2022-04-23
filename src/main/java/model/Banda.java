package model;

import java.util.List;

public class Banda {
    private int id;
    private String nome;
    private Genero genero;
    private List<Integrante> integranteList;

    public Banda() { }

    public Banda(int id) {
        this.id = id;
    }

    public Banda(String nome, Genero genero) {
        this.nome = nome;
        this.genero = genero;
    }

    public Banda(int id, String nome, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Integrante> getIntegranteList() {
        return integranteList;
    }

    public void setIntegranteList(List<Integrante> integranteList) {
        this.integranteList = integranteList;
    }

    @Override
    public String toString() {
        return "Banda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero=" + genero +
                '}';
    }
}
