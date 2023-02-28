import java.util.List;

public class Aluno extends Pessoa{

    private List<Matricula> minhasMatriculas;
    private int LIMITEDISCIPLINAS;
    private int DISCIPLINASAOBRIGATORIAS;

    public Aluno(String nome, String user, String senha){
        super(nome, user, senha);
    }

    public Matricula matricular(Disciplina disciplina){

        return null;
    }

    public boolean desmatricular(Disciplina disciplina){

        return false;
    }

}
