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

    public void gerarExtrato() throws IllegalAccessException {

        for(Despesa despesa : Main.DESPESAS){
            if(despesa.getAluno().equals(this)){
                System.out.println("/Despesa Aluno" + this.getNome());
                System.out.println("/n-----------------------------");
                System.out.println("Valor" + despesa.getValor());
                System.out.println((despesa.getStatus() == true) ? "Status: Pago"
                        : "Status: Aguardando pagamento");
            }
        }
    }


    public Matricula realizarMatricula(Disciplina disciplina) throws Exception {

        int[] vetor = Matricula.retornaQuantidadeMatriculasAluno(this);
        

        if(disciplina.getObrigatorio() == true &&  vetor[0] < 4){
            Matricula matricula =  new Matricula(this, disciplina);
            Main.MATRICULAS.add(matricula);
            return matricula;
        }
        else if(disciplina.getObrigatorio() == false &&  vetor[1] < 2 &&  vetor[4] < 4){
            Matricula matricula =  new Matricula(this, disciplina);
            Main.MATRICULAS.add(matricula);
            return matricula;
        }
        else
            throw new Exception("O aluno ultrapassou o número de disciplinas limite");
    }


    public boolean cancelarMatricula(Disciplina disciplina) throws IllegalAccessException{

        Matricula matricula_remover = null;

        for(Matricula matricula : Main.MATRICULAS){

            if(matricula.getDisciplina().equals(disciplina) 
            && matricula.getAluno().equals(this)){
                matricula_remover = matricula;
            }
        }

        if(matricula_remover == null){
            return false;
        }else{
            Main.MATRICULAS.remove(matricula_remover);
            return true;
        }

    }


}
