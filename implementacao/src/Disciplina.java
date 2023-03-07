import java.util.List;

public class Disciplina implements iRelatorio{

    public String nome;
    public Professor prof;
    private boolean obrigatorio;
    private boolean status;
    private List<Matricula> matriculas;

    public Disciplina(String nome, Professor professor, boolean obrigatorio){

    }

    public boolean ativaDisciplina(){

        return false;
    }

    public boolean addMatricula(Matricula matricula){

        return false;
    }

    public boolean deleteMatricula(Matricula matricula){

        return false;
    }

    @Override
    public String gerarRelatorio() {
        return null;
    }
}
