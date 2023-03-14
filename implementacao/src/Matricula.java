public class Matricula {

    private static long idControl=0;
    private long id;
    private Aluno aluno;
    private Disciplina disciplina;
    private boolean status;

    public Matricula(Aluno aluno, Disciplina disciplina){

        this.aluno = aluno;
        this.disciplina = disciplina;
        
        Matricula.idControl++;
        this.id = Matricula.idControl;
        this.status = true;
    }

    public long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
