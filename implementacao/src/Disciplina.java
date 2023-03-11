public class Disciplina implements iRelatorio{

    public String nome;
    public Professor professor;
    private boolean obrigatoria;

    public Disciplina(String nome, Professor professor, boolean obrigatorio){
        this.nome = nome;
        this.professor = professor;
        this.obrigatoria = obrigatorio;
    }

    @Override
    public String gerarRelatorio() {

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("nome: " + this.nome +"\n");
        relatorio.append("professor: " + this.professor);
        if(obrigatoria)
            relatorio.append("obrigatoria");

        return relatorio.toString();
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public boolean getObrigatorio() {
        return this.obrigatoria;
    }
    
}
