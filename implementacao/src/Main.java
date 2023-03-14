import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class Main{
	
 	public static final Scanner TECLADO = new Scanner(System.in);

 	public static final Universidade UNIVERSIDADE = new Universidade("UniversidadeX");

    public static final LinkedList<Matricula> MATRICULAS = new LinkedList<>();

    public static final LinkedList<Despesa> DESPESAS = new LinkedList<>();


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
 				default:
 					System.out.println("Opção não disponível");
 			}
			
			
 		}while(opcao != "0");
		
		
			
 	}
	
	
 	public static HashMap<Integer, String> retornaOpcoes(){

 		HashMap<Integer, String> values = new HashMap<>();
	
 		values.put(0, "Sair");
 		values.put(1, "Logar");

        return values;
	
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
 }
