public class Despesa {

    private static long idControl = 0;
    private long id;
    private double valor;
    private boolean status;
    private Aluno aluno;

    Despesa(Double valor, Aluno aluno){
        this.valor = valor;
        this.aluno = aluno;
        this.status = false;
        Despesa.idControl++;
        this.id = Despesa.idControl;
    }


    /**
     * recebe um status e se ele for diferente do status existente, sempre iniciado com falso,
     * e verdadeiro, altera seu valor, caso não for é lançada uma exceção de acordo com cada caso.
     */
    public void setStatus(boolean status) throws Exception{
        if(this.status != status && status == true)
            this.status = status;
        else if(this.status == status == true)
            throw new Exception("Essa despesa já foi paga!");
        else if(this.status == status == false)
            throw new Exception("Essa despesa não pode ser cancelada!");
    }

    public boolean getStatus() {
        return this.status;
    }

    public double getValor() {
        return valor;
    }

    public long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

}
