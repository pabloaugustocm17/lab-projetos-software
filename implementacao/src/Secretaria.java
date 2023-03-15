
public class Secretaria extends Pessoa{

    Secretaria(String nome, String userName, String senha) {

        super(nome, userName, senha);
    }

    public void gerarCurriculo(){
        
        for(Curso curso : Main.CURSOS){
            System.out.println(curso.gerarRelatorio());
        }

    }

}
