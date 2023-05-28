package Np2;

class Aluno {
    private String id;
    private String nome;

    public Aluno(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}