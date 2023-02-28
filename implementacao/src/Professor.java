import java.util.List;

public class Professor extends Pessoa{

    private List<Disciplina> disciplinas;

    public Professor(String nome, String user, String senha){
        super(nome, user, senha);
    }
}
