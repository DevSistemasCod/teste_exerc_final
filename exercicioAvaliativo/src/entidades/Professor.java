package entidades;

public class Professor extends Pessoa {
	private String especialidade;
    private Disciplina disciplina;
    private String periodo;

    
  //Construtor padrao
    public Professor(String nome, String cpf) {
		super(nome, cpf);
	}
    
    //Construtor com todos os atributos
    public Professor(String nome, String cpf, String especialidade, Disciplina disciplina, String periodo) {
        super(nome, cpf);
        this.especialidade = especialidade;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }


	public String getEspecialidade() {
        return especialidade;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("-- Informacoes do Professor --");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Periodo: " + periodo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidade: " + especialidade +
                ", Disciplina: " + disciplina + ", Período: " + periodo;
    }
}
