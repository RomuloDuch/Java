package Np2;

public class Rendimento {
	
	private Aluno aluno;
    private Curso curso;
    private double notaNP1;
    private double notaNP2;
    private double notaReposicao;
    private double notaExame;

    public Rendimento(Aluno aluno, Curso curso, double notaNP1, double notaNP2, double notaReposicao, double notaExame) {
        this.aluno = aluno;
        this.curso = curso;
        this.notaNP1 = notaNP1;
        this.notaNP2 = notaNP2;
        this.notaReposicao = notaReposicao;
        this.notaExame = notaExame;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public double getNotaNP1() {
        return notaNP1;
    }

    public double getNotaNP2() {
        return notaNP2;
    }

    public double getNotaReposicao() {
        return notaReposicao;
    }

    public double getNotaExame() {
        return notaExame;
    }

    public boolean isAprovado() {
        double mediaInicial = Math.max(Math.min(notaNP1, notaNP2), notaReposicao);
        double mediaFinal;

        if (curso.getNivel().equals("graduacao")) {
            if (mediaInicial >= 7.0) {
                return true;
            } else {
                mediaFinal = (mediaInicial + notaExame) / 2.0;
                return mediaFinal >= 5.0;
            }
        } else if (curso.getNivel().equals("pos_graduacao")) {
            if (mediaInicial >= 5.0) {
                return true;
            } else {
                mediaFinal = (mediaInicial + notaExame) / 2.0;
                return mediaFinal >= 5.0;
            }
        }

        return false;
    }

    public double calcularMedia() {
        double mediaInicial = Math.max(Math.min(notaNP1, notaNP2), notaReposicao);
        double mediaFinal;

        if (curso.getNivel().equals("graduacao")) {
            if (mediaInicial >= 7.0) {
                return mediaInicial;
            } else {
                mediaFinal = (mediaInicial + notaExame) / 2.0;
                if (mediaFinal >= 5.0) {
                    return mediaFinal;
                } else {
                    return mediaFinal;
                }
            }
        } else if (curso.getNivel().equals("pos_graduacao")) {
            if (mediaInicial >= 5.0) {
                return mediaInicial;
            } else {
                mediaFinal = (mediaInicial + notaExame) / 2.0;
                if (mediaFinal >= 5.0) {
                    return mediaFinal;
                } else {
                    return mediaFinal;
                }
            }
        }

        return 0.0;
    }

    @Override
    public String toString() {
        return curso.getNome() + " - " + curso.getNivel() + " - " + curso.getAno() + "\n" +
                "Aluno: " + aluno.getNome() + " (" + aluno.getId() + ")\n" +
                "Notas: NP1=" + notaNP1 + ", NP2=" + notaNP2 + ", Reposição=" + notaReposicao + ", Exame=" + notaExame + "\n" +
                "Média: " + calcularMedia() + "\n" +
                "Aprovado: " + isAprovado();
    }
    
}