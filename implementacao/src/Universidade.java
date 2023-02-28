import java.util.Date;
import java.util.List;

public class Universidade {

    public String nome;
    private List<Curso> cursos;
    private List<Pessoa> pessoas;
    private Semestre semestre;
    private Date DATAATUAL;

    public Universidade(String nome){

    }

    public String gerarCurriculo(String name){

        return "";
    }

    public void abrirSemestre(String inicio, String fim){

    }


    public boolean fecharSemestre(){

        return false;
    }

    public boolean addCurso(Curso curso){

        return false;
    }

    public boolean addDisciplina(String curso, Disciplina disc){

        return false;
    }

    public boolean deleteCurso(String curso){

        return false;
    }

    public boolean deleteDisciplaina(String disc){

        return false;
    }

    public boolean semestreAtivo(){

        return false;
    }

    public boolean cadastrar(String type, Pessoa pessoa){

        return false;
    }
}
