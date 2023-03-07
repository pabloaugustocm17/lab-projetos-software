import java.util.List;

public class Curso implements iRelatorio{

    public String curso;
    private List<Disciplina> disciplinas;
    public int creditos;

    public Curso(String curso, int creditos){

    }

    @Override
    public String gerarRelatorio() {
        return null;
    }


}
