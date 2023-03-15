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


 	public static final HashMap<Integer, String> VALORES_OPCOES = retornaOpcoes();

 	public static void main(String[] args){
		
        String opcao = "";

 		do{
			
 			VALORES_OPCOES.forEach((key, method) -> {
			
 				System.out.println(key + "-" + method);
			
 			});
			
 			opcao = TECLADO.next();
			
 			switch(opcao){
			
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
 				default:
 					System.out.println("Opção não disponível");
 			}
			
			
 		}while(opcao != "0");
		
		
			
 	}
	
	
 	public static HashMap<Integer, String> retornaOpcoes(){

 		HashMap<Integer, String> values = new HashMap<>();
	
 		values.put(0, "Sair");
 		values.put(1, "Logar");
		values.put(2, "Cadastrar Aluno");
        values.put(3, "Cadastrar professor");
        values.put(4, "Cadastra Secretária");
        
        return values;
	
 	}	

	public static void cadastra(String tipo){
		
		System.out.println("Informe seu username: ");
		String nome = TECLADO.next();
		System.out.println("Informe seu username: ");
 		String username = TECLADO.next();
		
		boolean isValido = validaUserName(username);
		
		do{
			
			System.out.println("Username já existe, informe seu novo username: ");
 			username = TECLADO.next();
			
		}while(!isValido);
		
 		System.out.println("Informe sua senha: ");
 		String senha = TECLADO.next();

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
 		String username = TECLADO.next();
 		System.out.println("Informe sua senha: ");
 		String senha = TECLADO.next();
		
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

 }
