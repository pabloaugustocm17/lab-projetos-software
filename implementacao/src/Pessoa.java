public abstract class Pessoa implements iRelatorio{

    public String nome;
    public String userName;
    public String senha;

    Pessoa(String nome, String userName, String senha){

    }

    public boolean validarLogin(String userName, String senha){

        return false;
    }

    @Override
    public String gerarRelatorio(){

        return "";
    }



}
