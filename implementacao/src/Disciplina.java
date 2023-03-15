import java.util.LinkedList;

public class Disciplina implements iRelatorio{

    public String nome;
    public Professor professor;
    private boolean obrigatoria;

    public Disciplina(String nome, Professor professor, boolean obrigatorio){
        this.nome = nome;
        this.professor = professor;
        this.obrigatoria = obrigatorio;
    }

    public LinkedList<Aluno> getAlunos(){
        
        LinkedList<Aluno> alunos = new LinkedList<>();

        for (Matricula matricula : Main.MATRICULAS) {
            alunos.add(matricula.getAluno());
        }

        return alunos;
    }

    @Override
    public String gerarRelatorio() {

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("nome: " + this.nome +"\n");
        relatorio.append("professor: " + this.professor.getNome());
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

    public String getNome() {
        return this.nome;
    }

}
