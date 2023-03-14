public class app {
    public static void main(String[] args) {

        Universidade uni = new Universidade("UNI");

        Curso c1 = new Curso("AEDS", 0, uni);
        // Curso c2 = new Curso("POO", 0, uni);
        // Curso c3 = new Curso("FPAA", 0, uni);
        
        Aluno a1 = new Aluno("arthur", "arthur", "ar");
        Aluno a2 = new Aluno("alexi", "alexi", "ar");
        Professor p1 = new Professor("arthur", "arthur", "ar");
        Pessoa s1 = new Secretaria("arthur", "arthur", "ar");

        Disciplina d1 = new Disciplina("Disciplina", p1, true);
        Disciplina d2 = new Disciplina("DISC", p1, true);

        
        try {
           System.out.println( a1.realizarMatricula(d1).getId());
           System.out.println( a1.realizarMatricula(d2).getId());
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        
        
    }
}
