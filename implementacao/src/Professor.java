import java.util.List;

public class Professor extends Pessoa{

    private List<Disciplina> disciplinas;

    public Professor(String nome, String user, String senha){
        super(nome, user, senha);
    }

    public String visualizarDisciplinas(){

        return "";
    }

    public String visualizarAlunos(Disciplina disc){

        return "";
    }

    @Override
    public String gerarRelatorio(){

        return "";
    }
}
