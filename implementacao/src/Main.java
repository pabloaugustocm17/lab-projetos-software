import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class Main{
	
 	public static final Scanner TECLADO = new Scanner(System.in);

    public static final Random RANDOM = new Random();

 	public static final Universidade UNIVERSIDADE = new Universidade("UniversidadeX");

    public static final LinkedList<Matricula> MATRICULAS = new LinkedList<>();

    public static final LinkedList<Despesa> DESPESAS = new LinkedList<>();

    public static final LinkedList<Professor> PROFESSORES = new LinkedList<>();

    public static final LinkedList<Secretaria> SECRETARIAS = new LinkedList<>();

	public static final LinkedList<Curso> CURSOS = new LinkedList<>();


 	public static final HashMap<Integer, String> VALORES_OPCOES = retornaOpcoes();

 	public static void main(String[] args) throws Exception{
		
        String opcao = "";

 		do{
			
 			VALORES_OPCOES.forEach((key, method) -> {
			
 				System.out.println(key + "-" + method);
			
 			});
			
 			opcao = TECLADO.next();
			
 			switch(opcao){
			
				case("0"):
					opcao = null;
					break;
 				case("1"):
 					realizaLogin();
 					break;
				case("2"):
				 	cadastra("Aluno");
				    break;
                case ("3"):
                    cadastra("Professor");
                    break;    
                case ("4"):
                    cadastra("Secretaria");
                    break;   
				case ("5"):
					geraRelatorio();
					break;	
				case ("6"):
					realizaMatricula();
					break;			
				case ("7"):
					criaCurso();
					break;	
				case ("8"):
					registraDisciplina();
					break;	
				case ("9"):
					cancelaDisciplina();
					break;
				case("10"):
					verAlunos();
					break;	
 				default:
 					System.out.println("Opção não disponível");
 			}
			
			
 		}while(opcao != null);
		
		
			
 	}
	
	
 	public static HashMap<Integer, String> retornaOpcoes(){

 		HashMap<Integer, String> values = new HashMap<>();
	
 		values.put(0, "Sair");
 		values.put(1, "Logar");
		values.put(2, "Cadastrar Aluno");
        values.put(3, "Cadastrar Professor");
        values.put(4, "Cadastra Secretária");
		values.put(5, "Gera relatório");
		values.put(6, "Realiza Matrícula");
        values.put(7, "Cria Curso");
		values.put(8, "Registra Disciplina");
		values.put(9, "Cancela Disciplina");
		values.put(10, "Ver alunos em disciplina");

        return values;
	
 	}	

	public static void cadastra(String tipo){
		
		System.out.println("Informe seu nome: ");
		String nome = TECLADO.nextLine();
		System.out.println("Informe seu username: ");
 		String username = TECLADO.nextLine();
		
		boolean isValido = validaUserName(username);
		
		while(!isValido){
			
			System.out.println("Username já existe, informe seu novo username: ");
 			username = TECLADO.nextLine();
			
		}
		
 		System.out.println("Informe sua senha: ");
 		String senha = TECLADO.nextLine();

        if(tipo.equals("Aluno")){
            cadastraAluno(nome, username, senha);    
        }else if(tipo.equals("Professor")){
            cadastraProfessor(username, senha, nome);
        }else if(tipo.equals("Secretaria")){
            cadastraSecretaria(username, senha, nome);
        }
		

		
	
	}
				     
	public static boolean validaUserName(String username){
		
        AtomicBoolean valido = new AtomicBoolean(true);

        UNIVERSIDADE.getPessoas().forEach(pessoa -> {

            if(pessoa.getUserName().equals(username)){
				valido.set(false);
			}

        });
		
		return valido.get();
		
	}
				     
 	public static void realizaLogin(){
		
 		System.out.println("Informe seu username: ");
 		String username = TECLADO.nextLine();
 		System.out.println("Informe sua senha: ");
 		String senha = TECLADO.nextLine();
		
 		if(realizaLogin(username, senha)){
 			System.out.println("Login realizado com sucesso");
 		}else{
 			System.out.println("Dados informados errados");
 		}
		
 	}

 	private static boolean realizaLogin(String username, String senha){
		
 		AtomicBoolean atomic = new AtomicBoolean(false);
		
 		UNIVERSIDADE.getPessoas().forEach(pessoa -> {
			
 			if(pessoa.getUserName().equals(username) && pessoa.getSenha().equals(senha)){
 				atomic.set(true);
 			}
		
 		});
		
 		return atomic.get();
		
 	}
	
	private static Aluno cadastraAluno(String username, String senha, String nome){
		
		Aluno aluno = new Aluno(nome, username, senha);
		
		UNIVERSIDADE.getPessoas().forEach(pessoa -> {
			
			if(aluno.equals(pessoa)){
				throw new RuntimeException("Aluno já cadastrado");
			}
			
		});
		
		UNIVERSIDADE.getPessoas().add(aluno);
        DESPESAS.add(new Despesa(RANDOM.nextDouble(1000), aluno));

		return aluno;
		
	}

    private static Professor cadastraProfessor(String username, String senha, String nome){

        Professor professor_novo = new Professor(nome, username, senha);

        PROFESSORES.forEach(professor -> {
            if(professor.equals(professor_novo)){
                throw new RuntimeException("Professor já existe");
            }
        });

        PROFESSORES.add(professor_novo);

        return professor_novo;

    }

    private static Secretaria cadastraSecretaria(String username, String senha, String nome){

        Secretaria secretaria_novo = new Secretaria(nome, username, senha);

        SECRETARIAS.forEach(professor -> {
            if(professor.equals(secretaria_novo)){
                throw new RuntimeException("Secretária já existe");
            }
        });

        SECRETARIAS.add(secretaria_novo);

        return secretaria_novo;

    }

	private static void realizaMatricula() throws Exception{

		Aluno pessoa_utilizar = procuraAluno();

		if(pessoa_utilizar == null){
			System.out.println("Aluno não existe");
			return;
		}

		Disciplina disciplina_utilizar = procuraDisciplina();

		if(disciplina_utilizar == null){
			System.out.println("Disciplina não encontrada");
			return;
		}

		pessoa_utilizar.realizarMatricula(disciplina_utilizar);

		
	}

	private static void geraRelatorio(){

		try{

			FileWriter escritor = new FileWriter("relatorio");

			BufferedWriter buffer_escritor = new BufferedWriter(escritor);

			buffer_escritor.write("CURSOS: ");
			buffer_escritor.newLine();

			for(Curso curso : CURSOS){

				buffer_escritor.write("Nome curso: " + curso.getNome());
				buffer_escritor.newLine();

				buffer_escritor.write("DISCIPLINAS: ");

				for(Disciplina disciplina : curso.getDisciplinas()){
					buffer_escritor.write(disciplina.gerarRelatorio());
					buffer_escritor.newLine();
				}

			}


			buffer_escritor.write("MATRICULAS: ");
			buffer_escritor.newLine();

			for(Matricula matricula : MATRICULAS){

				buffer_escritor.write("Aluno: " + matricula.getAluno().getNome());
				buffer_escritor.newLine();
				buffer_escritor.write("Disciplina: " + matricula.getDisciplina().getNome());
				buffer_escritor.newLine();
			}


			buffer_escritor.close();

			

		}catch(IOException ioException){
			throw new RuntimeException("ioException: " + ioException);
		}

		


	}

	private static void criaCurso(){

		System.out.println("Informe o nome do curso: ");
		String nome_curso = TECLADO.nextLine();

		for(Curso curso : CURSOS){

			if(curso.getNome().equals(nome_curso)){
				throw new RuntimeException("Curso já existe");
			}
		}

		Curso curso = new Curso(nome_curso, 0, UNIVERSIDADE);
		CURSOS.add(curso);

	}

	private static void registraDisciplina(){

		Curso curso_utilizar = procuraCurso();

		if(curso_utilizar == null){
			System.out.println("Curso não existe");
			return;
		}

		System.out.println("Informe o nome da nova disciplina: ");
		String nome_disciplina = TECLADO.nextLine();

		System.out.println("Disciplina é obrigatória(S/N): ");
		String obrigatoria = TECLADO.nextLine();
		
		Professor professor_utilizar = procuraProfessor();

		if(professor_utilizar == null){
			System.out.println("Professor não existe");
			return;
		}

		boolean obg = false;

		if(obrigatoria.equals("S")){
			obg = true;
		}

		Disciplina disciplina = new Disciplina(nome_disciplina, professor_utilizar, obg);

		curso_utilizar.adicionarDisciplina(disciplina);


	}

	private static void cancelaDisciplina() throws IllegalAccessException{

		Aluno aluno = procuraAluno();

		if(aluno == null){
			System.out.println("Aluno não existe");
			return;
		}

		Disciplina disciplina_utilizar = procuraDisciplina();

		if(disciplina_utilizar == null){
			System.out.println("Disciplina não existe");
			return;
		}


		aluno.cancelarMatricula(disciplina_utilizar);

	}

	private static Aluno procuraAluno(){

		System.out.println("Informe o nome do aluno: ");
		String nome_aluno = TECLADO.nextLine();

		Aluno aluno = null;

		for (Pessoa pessoas : UNIVERSIDADE.getPessoas()) {
			
			if(pessoas.getNome().equals(nome_aluno)){
				aluno = (Aluno) pessoas;
			}

		}

		return aluno;

	}

	private static Disciplina procuraDisciplina(){

		System.out.println("Informe a disciplina: ");
		String nome_disciplina = TECLADO.nextLine();

		Disciplina disciplina_utilizar = null;

		for(Curso curso : CURSOS){

			for(Disciplina disciplina : curso.getDisciplinas()){

				if(disciplina.getNome().equals(nome_disciplina)){
					disciplina_utilizar = disciplina;
				}

			}
		}

		return disciplina_utilizar;

	}

	private static Curso procuraCurso(){

		System.out.println("Informe o nome do curso que receberá a disciplina: ");
		String nome_curso = TECLADO.nextLine();

		Curso curso_utilizar = null;

		for (Curso curso : CURSOS) {
		
			if(curso.getNome().equals(nome_curso)){
				curso_utilizar = curso;
			}
		}

		return curso_utilizar;

	}

	private static Professor procuraProfessor(){

		System.out.println("Inform o nome do professor: ");
		String nome_professor = TECLADO.nextLine();

		Professor professor_utilizar = null;

		for(Professor professor : PROFESSORES){

			if(professor.getNome().equals(nome_professor)){
				professor_utilizar = professor;
			}
		}

		return professor_utilizar;


	}

	private static void verAlunos(){

		Disciplina disciplina = procuraDisciplina();

		for(Aluno aluno : disciplina.getAlunos()){

			System.out.println("Aluno: " + aluno.getNome());

		}

		System.out.println("Professor: " + disciplina.getProfessor().getNome());


	}
}
