package model;

public class Integrante {
    private int id;
    private String nome;
    private String cpf;
    private Banda banda;

    public Integrante() { }

    public Integrante(int id) {
        this.id = id;
    }

    public Integrante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integrante(String nome, String cpf, Banda banda) {
        this.nome = nome;
        this.cpf = cpf;
        this.banda = banda;
    }

    public Integrante(int id, String nome, String cpf, Banda banda) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.banda = banda;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", banda=" + banda +
                '}';
    }
}
