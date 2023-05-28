package Np2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class FaculdadeApp {
	  public static void main(String[] args) {
	        SistemaFaculdade faculdade = new SistemaFaculdade();

	        /*Leitura dos dados persistentes (opcional)*/
	        try {
	            FileInputStream fileInputStream = new FileInputStream("alunos.dat");
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            faculdade.alunos = (List<Aluno>) objectInputStream.readObject();
	            objectInputStream.close();
	            fileInputStream.close();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Erro ao ler arquivo de alunos.");
	        }

	        try {
	            FileInputStream fileInputStream = new FileInputStream("cursos.dat");
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            faculdade.cursos = (List<Curso>) objectInputStream.readObject();
	            objectInputStream.close();
	            fileInputStream.close();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Erro ao ler arquivo de cursos.");
	        }

	        try {
	            FileInputStream fileInputStream = new FileInputStream("rendimentos.dat");
	            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	            faculdade.rendimentos = (Map<Curso, List<Rendimento>>) objectInputStream.readObject();
	            objectInputStream.close();
	            fileInputStream.close();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Erro ao ler arquivo de rendimentos.");
	        }

	        // Exemplo de uso do sistema de cadastro e relatórios
	        faculdade.cadastrarAluno("A001", "João");
	        faculdade.cadastrarAluno("A002", "Maria");
	        faculdade.cadastrarAluno("A003", "Pedro");

	        faculdade.cadastrarCurso("Engenharia", "graduacao", 2021);
	        faculdade.cadastrarCurso("Direito", "graduacao", 2021);
	        faculdade.cadastrarCurso("Administração", "graduacao", 2022);

	        faculdade.cadastrarRendimento("A001", "Engenharia", "graduacao", 2021, 8.0, 7.0, 0.0, 0.0);
	        faculdade.cadastrarRendimento("A002", "Engenharia", "graduacao", 2021, 7.5, 6.0, 0.0, 0.0);
	        faculdade.cadastrarRendimento("A003", "Engenharia", "graduacao", 2021, 6.0, 5.5, 0.0, 0.0);
	        faculdade.cadastrarRendimento("A001", "Direito", "graduacao", 2021, 7.0, 6.5, 0.0, 0.0);
	        faculdade.cadastrarRendimento("A002", "Direito", "graduacao", 2021, 5.5, 5.0, 0.0, 0.0);
	        faculdade.cadastrarRendimento("A003", "Direito", "graduacao", 2021, 6.5, 7.0, 0.0, 0.0);

	        faculdade.listarAlunos();
	        faculdade.listarCursos();
	        faculdade.listarCursosPorAno(2021);

	        faculdade.mostrarRelatorioAluno("A001");
	        faculdade.mostrarRelatorioCurso("Engenharia", "graduacao", 2021);

	        // Gravação dos dados persistentes (opcional)
	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream("alunos.dat");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            objectOutputStream.writeObject(faculdade.alunos);
	            objectOutputStream.close();
	            fileOutputStream.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao gravar arquivo de alunos.");
	        }

	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream("cursos.dat");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            objectOutputStream.writeObject(faculdade.cursos);
	            objectOutputStream.close();
	            fileOutputStream.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao gravar arquivo de cursos.");
	        }

	        try {
	            FileOutputStream fileOutputStream = new FileOutputStream("rendimentos.dat");
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
	            objectOutputStream.writeObject(faculdade.rendimentos);
	            objectOutputStream.close();
	            fileOutputStream.close();
	        } catch (IOException e) {
	            System.out.println("Erro ao gravar arquivo de rendimentos.");
	        }
	    }
}

