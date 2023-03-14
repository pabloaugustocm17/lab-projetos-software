import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Universidade {

    public String nome;
    private List<Pessoa> pessoas;

    public Universidade(String  name){
        this.nome = name;
        this.pessoas = new LinkedList<>();
    }

    public Universidade(String  name, List<Pessoa> pessoas){
        this.nome = name;
        this.pessoas = new LinkedList<>(pessoas);
    }


    /**
     * Aceita tanto o formato DD/MM/YYYY quanto DD-MM-YYYY
     * @param inicio -> Data que o semestre irá iniciar
     * @param fim -> Data que o semstre irá fechar
     * @throws ParseException
     */
    public Semestre abrirSemestre(String inicio, String fim) throws ParseException{
        Date start;
        Date end;

        start = trataData(inicio);
        end = trataData(fim);
        return new Semestre(start, end,this);
    }

    private Date trataData(String data) throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy"); 
        Date date= null;
        if(data.contains("/"))
        date =  formato.parse(data);
        else if(data.contains("-"))
            date =   formato2.parse(data);

        if(date != null)
            return date;
        else
            throw new ParseException("Formato da data está errado", 0);
    }

    public boolean fecharSemestre(Semestre semestre){
        semestre.setAberto(false);
        return false;
    }


    public boolean criaCurso(String nome, long credito){
        Curso curso = new Curso(nome, credito,this);
        Main.CURSOS.add(curso);
        return false;

    }

    public boolean cancelarCurso(Curso curso) throws IllegalAccessException{


        Curso curso_Remover = null;

        for(Curso cursoTemp : Main.CURSOS){

            if(cursoTemp.equals(curso)){
                curso_Remover = curso;
            }
        }

        if(curso_Remover == null){
            return false;
        }else{
            Main.CURSOS.remove(curso_Remover);
            return true;
        }
        
    }


    public boolean adicionarPessoa(Pessoa pessoa){
        return this.pessoas.add(pessoa);
    }

    public boolean retirarPessoa(Pessoa pessoa){
        return this.pessoas.remove(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return new LinkedList<>(this.pessoas);
    }

}