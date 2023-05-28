package Np2;

public class Curso {
	private String nome;
    private String nivel;
    private int ano;

    public Curso(String nome, String nivel, int ano) {
        this.nome = nome;
        this.nivel = nivel;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getNivel() {
        return nivel;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return nome + " (" + nivel + ") - " + ano;
    }

}
