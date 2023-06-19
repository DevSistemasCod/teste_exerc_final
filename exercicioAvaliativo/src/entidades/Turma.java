package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Turma {
	private Aluno aluno;
	private File arquivo;
	private String identificacao;
	private String path;
    private ArrayList<Aluno> listaDeAlunos;
    private static final String EXTENSAO_ARQUIVO = ".csv";

    public Turma(String identificacao, String path) {
        this.identificacao = identificacao;
        this.path = path;
        listaDeAlunos = new ArrayList<Aluno>();
    }


    public String getIdentificacao() {
        return identificacao;
    }
    ////
    public void carregarAlunos() {
        String nomeArquivo = path + EXTENSAO_ARQUIVO;
        arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] registros = linha.split(",");

                String nome = registros[0];
                String cpf = registros[1];
                String codigoTurma = registros[2];
                Disciplina disciplina = Disciplina.valueOf(registros[3]);
                Double media = Double.parseDouble(registros[4]);
                
                aluno = new Aluno(nome, cpf, codigoTurma, disciplina, media);
            }

            System.out.println("Alunos carregados do arquivo com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo."+e.getMessage());
        }
    }
    ////
    public void removerAluno(String cpf) {
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            aluno = listaDeAlunos.get(i);
            if (aluno.getCpf() == cpf) {
            	listaDeAlunos.remove(i);
                System.out.println("Aluno removido com sucesso.");
                return;
            }
        }

        System.out.println("Aluno não encontrado.");
    }
    ////
    
    public ArrayList<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void adicionarAluno(Aluno aluno) {
    	boolean cpfExistente = false;
        for (Aluno a : listaDeAlunos) {
            if (a.getCpf().equals(aluno.getCpf())) {
                cpfExistente = true;
                break;
            }
        }

        if (cpfExistente) {
            System.out.println("O CPF já está cadastrado na turma.");
        } else {
            listaDeAlunos.add(aluno);
            System.out.println("Aluno adicionado à turma com sucesso.");
        }
    }

    public void removerAluno(Aluno aluno) {
        listaDeAlunos.remove(aluno);
    }
    
  
    public void listarAlunosDaTurma() {
    	if (listaDeAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
        } else {
            System.out.println("Lista de Alunos:");   
            for (Aluno aluno : listaDeAlunos) {
                System.out.println(aluno);
            }
        }
    }

    public void editarInformacoesDoAluno(String cpf, Aluno novosDadosAluno) {
        boolean sairLaco = true;
    	for (int i = 0; i < listaDeAlunos.size(); i++) {
            if (listaDeAlunos.get(i).getCpf().equals(cpf)) {
            	listaDeAlunos.set(i,novosDadosAluno);
            	sairLaco = false;
            	break;
            }
            if (sairLaco == false) {
            	break;
            }
    	} if(sairLaco){
            	System.out.println("Aluno não encontrado na turma.");
    	}
    }

    public void atualizarArquivo() {
    		String nomeArquivo = path + EXTENSAO_ARQUIVO;
            arquivo = new File(nomeArquivo);
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                for (Aluno aluno : listaDeAlunos) {
                	writer.write(aluno.toCSVString());
                    writer.newLine();
                }

                System.out.println("Arquivo atualizado com sucesso.");

            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo.");
                e.printStackTrace();
            }
        
    }
    
    public void salvarArquivo() {
    	 String nomeArquivo = path + EXTENSAO_ARQUIVO;
         File arquivo = new File(nomeArquivo);
         
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Aluno aluno : listaDeAlunos) {
                writer.write(aluno.toCSVString());
                writer.newLine();
            }
            System.out.println("As informações foram salvas no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar as informações no arquivo.");
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return "Turma: " + identificacao + ", Quantidade de Alunos: " + listaDeAlunos.size();
    }
}
