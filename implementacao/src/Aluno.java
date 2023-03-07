import java.util.List;

public class Aluno extends Pessoa{

    private List<Matricula> minhasMatriculas;
    private List<Despesa> minhasDespesas;

    public Aluno(String nome, String user, String senha){
        super(nome, user, senha);
    }

    public Matricula matricular(Disciplina disciplina){

        return null;
    }

    public boolean desmatricular(Disciplina disciplina){

        return false;
    }

    public void inscreverSemestre(){

    }

    public void pagar(Despesa despesa){

    }

    public String gerarExtrato(){

        return "";
    }

    @Override
    public String gerarRelatorio(){

        return "";
    }

}
