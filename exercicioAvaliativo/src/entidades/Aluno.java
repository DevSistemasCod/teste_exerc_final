package entidades;

import java.util.ArrayList;

public class Aluno extends Pessoa {
	private String codigoTurma;
	private String situacao;
	private Disciplina disciplina;
	private ArrayList<Double> notas;
	private Double media;

	//Construtor
	public Aluno(String nome, String cpf) {
		super(nome, cpf);
		notas = new ArrayList<Double>();
	}

	//Construtor
	public Aluno(String nome, String cpf, String codigoTurma, Disciplina disciplina) {
		super(nome, cpf);
		this.codigoTurma = codigoTurma;
		this.disciplina = disciplina;
		notas = new ArrayList<Double>();
	}

	public Aluno(String nome, String cpf, String codigoTurma, Disciplina disciplina, Double media) {
		super(nome, cpf);
		this.codigoTurma = codigoTurma;
		this.disciplina = disciplina;
		this.media = media;
	}
	
	//Getters and Setters
	public String getCodigoTurma() {
		return codigoTurma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public ArrayList<Double> getNotas() {
		return notas;
	}
	
	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public void adicionarNota(double nota) {
		notas.add(nota);
	}

	public void removerNota(int indice) {
		if (indice >= 0 && indice < notas.size()) {
			notas.remove(indice);
		}
	}

	public void listarNotas() {
		System.out.println("Notas do Aluno:");
		for (int i = 0; i < notas.size(); i++) {
			System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
		}
	}

	public double calcularMedia() {
		if (notas.isEmpty()) {
			return 0;
		}

		double soma = 0;
		for (double nota : notas) {
			soma += nota;
		}

		media = (soma / notas.size());
		
		if(media  >= 6.0) {
			situacao = "Aprovado";
		}else {
			situacao = "Reprovado";
		}
		
		return media;
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("Informações do Aluno:");
		System.out.println("Nome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Código da Turma: " + codigoTurma);
		System.out.println("Disciplina: " + disciplina);
		System.out.println("Média: " + calcularMedia());
		System.out.println("Situação: " + getMedia());
	}

	   public String toCSVString() {
	        String csvString = getNome() + "," + getCpf() + "," + codigoTurma + "," + disciplina.name() + "," + getMedia() + "," + getSituacao();
	        return csvString;
	    }
	
	
	@Override
	public String toString() {
		return super.toString() + ", Código da Turma: " + codigoTurma + ", Disciplina: " + disciplina + ", Média: "
				+ media + ", Situacao: " + situacao + "";
	}

}
