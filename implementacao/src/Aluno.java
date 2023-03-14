import java.lang.reflect.Field;

public class Aluno extends Pessoa{

    public Aluno(String nome, String userName, String senha){
        super(nome, userName, senha);
    }

    /**
     * recebe uma despesa e muda o status dela para true
     */
    public boolean pagar(Despesa despesa) {
        try {
            despesa.setStatus(true);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    /**
     * getDeclaredFields() => pega todos os atributos da classe Disciplina e armazena em um array do
     * tipo Field (tipo que representa um atributo de uma classe) e percorre ele procurando um
     * atributo "aluno", então acessa ele e compara o tipo dele com o da classe Aluno,
     * pega o valor do atributo e imprime os atributos da despesa de acordo com o status dela
     */
    public void gerarExtrato() throws IllegalAccessException {
        Field[] fields = Despesa.class.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals("aluno")){
                field.setAccessible(true);
                Despesa despesa = (Despesa) field.get(this);
                System.out.println("/Despesa Aluno" + this.getNome());
                System.out.println("/n-----------------------------");
                System.out.println("Valor" + despesa.getValor());
                System.out.println((despesa.getStatus() == true) ? "Status: Pago"
                        : "Status: Aguardando pagamento");
            }
        }
    }

    /**
     * getDeclaredFields() => pega todos os atributos da classe Matricula e armazena em um array do
     * tipo Field (tipo que representa um atributo de uma classe) e percorre ele procurando um
     * atributo "aluno" e uma disciplina com o nome diferente da recebida, então acessa ela e
     * compara o tipo dele com o da classe Matricula, pega o valor do atributo e verifica se ela é obrigatoria
     * ou não, contando a quantidade de cada uma e realizando ou não a matricula de acordo com isso
     */
    public Matricula realizarMatricula(Disciplina disciplina) throws Exception {

        int qtdMatriculasObg = 0;
        int qtdMatriculasOpc = 0;
        Field[] fields = Matricula.class.getDeclaredFields();
        for(Field field : fields) {
            if (field.getName().equals("aluno") && !field.getName().equals(disciplina.getNome())) {
                field.setAccessible(true);
                Matricula matricula = (Matricula) field.get(this);
                if (matricula.getStatus() == true) {
                    if (matricula.getDisciplina().getObrigatorio() == true)
                        qtdMatriculasObg++;
                    else
                        qtdMatriculasOpc++;
                }
            }
        }
        if(disciplina.getObrigatorio() == true &&  qtdMatriculasObg < 4)
            return new Matricula(this, disciplina);
        else if(disciplina.getObrigatorio() == false &&  qtdMatriculasOpc < 2 &&  qtdMatriculasObg < 4)
            return new Matricula(this, disciplina);
        else
            throw new Exception("O aluno ultrapassou o número de disciplinas limite");
    }

    /**
     * getDeclaredFields() => pega todos os atributos da classe Disciplina e armazena em um array do
     * tipo Field (tipo que representa um atributo de uma classe) e percorre ele procurando um
     * atributo "aluno" e uma disciplina com o nome da disciplina recebida no metodo, então acessa ele,
     * pega o valor do atributo e compara o tipo dele com o tipo da classe Aluno, se forem iguais altera
     * o status da matricula para falso.
     */
    public boolean cancelarMatricula(Disciplina disciplina) throws IllegalAccessException{
        Field[] fields = Matricula.class.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals("aluno") && field.getName().equals(disciplina)){
                field.setAccessible(true);
                Matricula matricula = (Matricula) field.get(this);
                matricula.setStatus(true);
                return true;
            }
        }
        return false;
    }


}
