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

    public static int[] retornaQuantidadeMatriculasAluno(Aluno aluno){

        int quantidadeMatriculasObrigatorias = 0;
        int quantidadeMatriculasNObrigatorias = 0;

        for(Matricula matricula : Main.MATRICULAS){

            if(matricula.getAluno().equals(aluno)){
                
                if(matricula.getDisciplina().getObrigatorio()){
                    quantidadeMatriculasObrigatorias++;
                }else{
                    quantidadeMatriculasNObrigatorias++;
                }

            }
        }

        int[] vetor = new int[2];

        vetor[0] = quantidadeMatriculasObrigatorias;
        vetor[1] = quantidadeMatriculasNObrigatorias;

        return vetor;

    }

}
