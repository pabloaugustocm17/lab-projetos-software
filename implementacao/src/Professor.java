import java.util.LinkedList;
import java.util.List;

public class Professor extends Pessoa{

    public Professor(String nome, String user, String senha){
        super(nome, user, senha);
    }

    public List<Disciplina> visualizarDisciplinas() {

        List<Disciplina> result = new LinkedList<>();

        System.out.println("\n--DISCIPLINAS--");
        for(Curso curso : Main.CURSOS){
            
            for (Disciplina disciplina : curso.getDisciplinas()) {
                if(disciplina.professor.getNome().equals(this.getNome())){
                    result.add(disciplina);
                    System.out.println("\n" + disciplina.gerarRelatorio());
                }
            }
        }

        return result;
        
    }

}
