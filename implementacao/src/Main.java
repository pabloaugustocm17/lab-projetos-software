class Main{
	
	public static final Scanner TECLADO = new Scanner();

	public static final UNIVERSIDADE = new Universidade("UniversidadeX");

	public static final HashMap<Integer, String> VALORES_OPCOES = retornaOpcoes();

	public static void main(String[] args){
		
		do{
			
			VALORES_OPCOES.forEach((key, method) -> {
			
				System.out.println(key + "-" + method);
			
			});
			
			String opcao = TECLADO.next();
			
			switch(opcao){
			
				case("1"):
					realizaLogin();
					break;
				default:
					System.out.println("Opção não disponível");
			}
			
			
		}while(opcao != "0");
		
		
			
	}
	
	
	public static void retornaOpcoes(){

		VALORES_OPCOES = new HashMap<>();
	
		VALORES_OPCOES.put(0, "Sair");
		VALORES_OPCOES.put(1, "Logar");
	
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
			
			if(pessoa.getUsername().equals(username) && pessoa.getSenha().equals(senha)){
				atomic.set(true);
			}
		
		})
		
		return atomic.get();
		
	}
}
