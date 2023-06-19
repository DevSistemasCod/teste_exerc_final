package entidades;

public enum Disciplina {
    FPOO("Fundamentos de Programacao Orientada a Objetos"),
    REDES("Redes de Computadores"),
    SO("Sistemas Operacionais"),
    LM("Linguagem de Marcacao");
    

    private String descricao;

    private Disciplina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}