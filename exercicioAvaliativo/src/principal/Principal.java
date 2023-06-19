package principal;

import entidades.Professor;
import entidades.Turma;

import java.util.Scanner;

import entidades.Aluno;
import entidades.Disciplina;

public class Principal {
	public static void main(String[] args) {
	    boolean permanecerLaco = true;
	    char editar;
	    double nota1, nota2;
	    Scanner lerDados = new Scanner(System.in);
	    
        Professor professor = new Professor("Zeca Urubu", "111", "Java", Disciplina.FPOO, "Manha");
        
        Aluno aluno1 = new Aluno("Pedro Souza", "123", "ADS-1", Disciplina.FPOO);
        Aluno aluno2 = new Aluno("Ana Alves", "321", "ADS-1", Disciplina.FPOO);
        Aluno aluno3 = new Aluno("Yusuke Urameshi", "456", "ADS-1", Disciplina.FPOO);
        Aluno aluno4 = new Aluno("Doug Funny", "654", "ADS-1", Disciplina.FPOO);
        Aluno aluno5 = new Aluno("Andre Silva", "754", "ADS-1", Disciplina.FPOO);

        // Adição de notas aos alunos
        aluno1.adicionarNota(7.5);
        aluno1.adicionarNota(8.0);
        aluno1.calcularMedia();
        
        aluno2.adicionarNota(6.5);
        aluno2.adicionarNota(7.0);
        aluno2.calcularMedia();
        
        aluno3.adicionarNota(4.0);
        aluno3.adicionarNota(3.0);
        aluno3.calcularMedia();
        
        aluno4.adicionarNota(5.0);
        aluno4.adicionarNota(6.0);
        aluno4.calcularMedia();
        
        aluno5.adicionarNota(4.0);
        aluno5.adicionarNota(1.0);
        aluno5.calcularMedia();
        
        
        // Criação de um objeto Turma
        Turma turma = new Turma("Turma A","arquivo");
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.adicionarAluno(aluno3);
        turma.adicionarAluno(aluno4);
        turma.adicionarAluno(aluno5);

        // Exibição dos alunos da turma
        turma.listarAlunosDaTurma();

        do {
        	System.out.println("Editar Informacoes de alunos:");
        	editar = lerDados.next().charAt(0);
        	if(editar == 'n' || editar == 'N' ) {
        		permanecerLaco = false;
        		break;
        	}
        	if(editar == 's' || editar == 'S') {
        		System.out.println("Editar Notas: ");
        		System.out.println("Informe a Nota 1: ");
        		nota1 = lerDados.nextDouble();
        		aluno3.adicionarNota(nota1);
        		
        		System.out.println("Informe a Nota 2: ");
        		nota2 = lerDados.nextDouble();
                aluno3.adicionarNota(nota2);
                aluno3.calcularMedia();
                break;
        	}
        }while(permanecerLaco);
        
        // Edição das informações de um aluno        
        turma.editarInformacoesDoAluno("456",aluno3);

        // Exibição dos alunos da turma após a edição
        turma.listarAlunosDaTurma();
        turma.atualizarArquivo();
        turma.removerAluno("754");
        turma.atualizarArquivo();
	}
}
