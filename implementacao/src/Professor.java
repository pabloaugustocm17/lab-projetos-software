import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{

    public Professor(String nome, String user, String senha){
        super(nome, user, senha);
    }

    public List<Disciplina> visualizarDisciplinas() {

        for(Disciplina disciplina : Main.DISCIPLINAS){
            System.out.println("/n--DISCIPLINAS--");
            if(disciplina.getProfessor().equals(this)){
            System.out.println(disciplina.getNome());
            }
        }
        
    }

}
