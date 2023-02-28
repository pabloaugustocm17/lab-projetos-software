import java.util.List;

public class Disciplina {

    public String nome;
    public Professor professor;
    private boolean obrigatorio;
    private boolean status;
    private List<Matricula> matriculas;

    public Disciplina(String nome, Professor professor, boolean obrigatorio){

    }

    public boolean ativaDisciplina(){

        return false;
    }
}
