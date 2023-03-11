import java.util.LinkedList;
import java.util.List;

public class Curso implements iRelatorio{

    public String nome;
    private List<Disciplina> disciplinas;
    public long creditos;
    public Universidade universidade;


    private void init(String nome, long creditos, Universidade universidade){
        this.nome = nome;
        this.creditos = creditos;
        this.universidade = universidade;
    }

    public Curso(String nome, long creditos, Universidade universidade){
        init(nome,creditos,universidade);
        this.disciplinas = new LinkedList<Disciplina>();
    }

    public Curso(String nome, long creditos, Universidade universidade, List<Disciplina> disciplinas){
        init(nome,creditos,universidade);
        this.disciplinas = new LinkedList<Disciplina>(disciplinas);
    }

    public boolean adicionarDisciplina(Disciplina disciplina) {
        return this.disciplinas.add(disciplina);
    }

    public boolean cancelarDisciplina(Disciplina disciplina) {
        return this.disciplinas.remove(disciplina);
    }


    @Override
    public String gerarRelatorio() {

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("nome: " + this.nome +"\n");
        relatorio.append("creditos: " + this.creditos +"\n");
        relatorio.append(" Disciplinas \n");
        for (Disciplina disciplina : disciplinas) {
            relatorio.append(disciplina.gerarRelatorio());
            relatorio.append("\n");
        }

        return relatorio.toString();
    }

    public Universidade getUniversidade() {
        return this.universidade;
    }

    public List<Disciplina> getDisciplinas() {
        return new LinkedList<>(this.disciplinas);
    }


}
