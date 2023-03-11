import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{

    public Professor(String nome, String user, String senha){
        super(nome, user, senha);
    }

    /**
     * getDeclaredFields() => pega todos os atributos da classe Disciplina e armazena em um array do
     * tipo Field (tipo que representa um atributo de uma classe) e percorre ele procurando um
     * atributo "professor", então acessa ele, pega o valor do atributo e compara o tipo dele
     * com o tipo da classe Professor, se forem iguais a Disciplina correspondente
     * é adicionada na lista de disciplinas.
     */

    public List<Disciplina> visualizarDisciplinas() throws IllegalAccessException {
        List<Disciplina> disciplinas = new ArrayList<>();
        Field[] fields = Disciplina.class.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals("professor")){
                field.setAccessible(true);
                Professor professor = (Professor) field.get(this);
                if(professor == this){
                    disciplinas.add((Disciplina) field.get(this));
                }
            }
        }
        return disciplinas;
    }

}
