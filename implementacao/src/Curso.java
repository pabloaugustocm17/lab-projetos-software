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
        this.disciplinas = new LinkedList<>();
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

        Disciplina disc = null;

        for(Disciplina discTemp : this.disciplinas){

            if(discTemp.equals(disciplina)){
                disc = discTemp;
            }
        }

        if(disc == null){
            return false;
        }else{
            this.disciplinas.remove(disc);
            return true;
        }
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


    public List<Disciplina> getDisciplinas() {
        return new LinkedList<>(this.disciplinas);
    }

    public String getNome(){
        return this.nome;
    }

}
