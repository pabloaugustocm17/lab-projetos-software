public abstract class Pessoa{

    private String nome;
    private String senha;
    private String userName;

    Pessoa(String nome, String senha, String userName){
        this.nome = nome;
        this.senha = senha;
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public String getUserName() {
        return userName;
    }

    public String getSenha() {
        return senha;
    }
}
