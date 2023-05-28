package Np2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFaculdade {
	private List<Aluno> alunos;
    private List<Curso> cursos;
    private Map<Curso, List<Rendimento>> rendimentos;

    public SistemaFaculdade() {
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
        rendimentos = new HashMap<>();
    }

    public void cadastrarAluno(String id, String nome) {
        Aluno aluno = new Aluno(id, nome);
        alunos.add(aluno);
    }

    public void listarAlunos() {
        System.out.println("---- Alunos Cadastrados ----");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
        System.out.println();
    }

    public void cadastrarCurso(String nome, String nivel, int ano) {
        Curso curso = new Curso(nome, nivel, ano);
        cursos.add(curso);
    }

    public void listarCursos() {
        System.out.println("---- Cursos Cadastrados ----");
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
        System.out.println();
    }

    public void listarCursosPorAno(int ano) {
        System.out.println("---- Cursos do Ano " + ano + " ----");
        for (Curso curso : cursos) {
            if (curso.getAno() == ano) {
                System.out.println(curso);
            }
        }
        System.out.println();
    }

    public void cadastrarRendimento(String idAluno, String nomeCurso, String nivelCurso, int anoCurso, double notaNP1,
                                    double notaNP2, double notaReposicao, double notaExame) {
        Aluno aluno = buscarAlunoPorId(idAluno);
        Curso curso = buscarCurso(nomeCurso, nivelCurso, anoCurso);

        if (aluno != null && curso != null) {
            Rendimento rendimento = new Rendimento(aluno, curso, notaNP1, notaNP2, notaReposicao, notaExame);
            List<Rendimento> rendimentosCurso = rendimentos.getOrDefault(curso, new ArrayList<>());
            rendimentosCurso.add(rendimento);
            rendimentos.put(curso, rendimentosCurso);
        } else {
            System.out.println("Aluno ou curso não encontrado.");
        }
    }

    public void mostrarRelatorioAluno(String idAluno) {
        Aluno aluno = buscarAlunoPorId(idAluno);

        if (aluno != null) {
            System.out.println("---- Relatório do Aluno " + aluno.getNome() + " (" + aluno.getId() + ") ----");
            for (Map.Entry<Curso, List<Rendimento>> entry : rendimentos.entrySet()) {
                List<Rendimento> rendimentosCurso = entry.getValue();
                for (Rendimento rendimento : rendimentosCurso) {
                    if (rendimento.getAluno().equals(aluno)) {
                        System.out.println(rendimento);
                    }
                }
            }
            double mediaHistorico = calcularMediaHistoricoAluno(aluno);
            System.out.println("Média do Histórico: " + mediaHistorico);
            System.out.println();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void mostrarRelatorioCurso(String nomeCurso, String nivelCurso, int anoCurso) {
        Curso curso = buscarCurso(nomeCurso, nivelCurso, anoCurso);

        if (curso != null) {
            System.out.println("---- Relatório do Curso " + curso.getNome() + " (" + curso.getNivel() + ") - " + curso.getAno() + " ----");
            List<Rendimento> rendimentosCurso = rendimentos.getOrDefault(curso, new ArrayList<>());
            for (Rendimento rendimento : rendimentosCurso) {
                System.out.println(rendimento.getAluno().getNome() + " - Média: " + rendimento.calcularMedia() + " - Aprovado: " + rendimento.isAprovado());
            }
            double mediaMedias = calcularMediaMediasCurso(rendimentosCurso);
            System.out.println("Média das Médias: " + mediaMedias);
            System.out.println();
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    private Aluno buscarAlunoPorId(String id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null;
    }

    private Curso buscarCurso(String nome, String nivel, int ano) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome) && curso.getNivel().equals(nivel) && curso.getAno() == ano) {
                return curso;
            }
        }
        return null;
    }

    private double calcularMediaHistoricoAluno(Aluno aluno) {
        int count = 0;
        double soma = 0.0;

        for (Map.Entry<Curso, List<Rendimento>> entry : rendimentos.entrySet()) {
            List<Rendimento> rendimentosCurso = entry.getValue();
            for (Rendimento rendimento : rendimentosCurso) {
                if (rendimento.getAluno().equals(aluno)) {
                    count++;
                    soma += rendimento.calcularMedia();
                }
            }
        }

        return (count > 0) ? soma / count : 0.0;
    }

    private double calcularMediaMediasCurso(List<Rendimento> rendimentosCurso) {
        int count = rendimentosCurso.size();
        double soma = 0.0;

        for (Rendimento rendimento : rendimentosCurso) {
            soma += rendimento.calcularMedia();
        }

        return (count > 0) ? soma / count : 0.0;
    }

}
