/* 115111580 - Lucas Diniz dos Santos: LAB 03 - Turma 2 */
package lab03;
import java.util.Scanner;

public class MenuPrincipal {
	
	private Scanner input;
	private Mercado mercado;
	
	public MenuPrincipal(){
		mercado = new Mercado();
		input = new Scanner(System.in);
	}
	
	public int leInteiro(String prompt){
		System.out.println(prompt);
		return Integer.parseInt(input.nextLine());
	}
	
	public String leString(String prompt){
		System.out.println(prompt);
		return input.nextLine();
	}
	
	public double leDouble(String prompt){
		System.out.println(prompt);
		return Double.parseDouble(input.nextLine());
	}

	
	public void cadastrarProduto(){
		
		String cadastrarOutro;
		
		do{

			String nome = leString("= = = = Cadastro de Produtos = = = =\nDigite o nome do produto:");
			
			double preco = leDouble("Digite o preco unitario do produto:");
			
			String tipo = leString("Digite o tipo de produto:");
	
			int quantidade = leInteiro("Digite a quantidade no estoque:");
			
			mercado.realizarCadastro(nome,preco,tipo,quantidade);
			
			System.out.println(quantidade + " " + nome + "(s) cadastrado(s) com sucesso!");
			
			cadastrarOutro = leString("Deseja cadastrar outro produto? (Sim/Nao)");
			
		}while(cadastrarOutro.equalsIgnoreCase("sim"));
	}
	
	public void venderProduto(){
		
		String venderOutro;
		
		do{
		
			String nome = leString("= = = = Venda de Produtos = = = =\nDigite o nome do produto:");
			
			if(mercado.existeProduto(nome)){
				String informacoes = mercado.informacoesDoProduto(nome);
				System.out.println("===> " + informacoes);
			}
			
			if(!mercado.existeProduto(nome)){
				System.out.println(nome + " nao cadastrado no sistema.\n");
			}
			
			else{
				int quantidadeDesejada = leInteiro("Digite a quantidade que deseja vender: ");
				
				if(!mercado.existeSuficiente(nome,quantidadeDesejada)){
					System.out.println("Nao e possivel vender pois nao ha " + nome + " suficiente.\n");
				}
						
				else{					
				
					double totalArrecadado = mercado.realizarVenda(nome,quantidadeDesejada);
					System.out.println("==> Total arrecadado: R$ " + totalArrecadado);
						
				}
			}
			
			venderOutro = leString("Deseja vender outro produto? (Sim/Nao)");
				
		}while(venderOutro.equalsIgnoreCase("sim"));
		
	}
	
	public void imprimirBalanco(){
		
		String balanco = mercado.balanco();
		System.out.println(balanco);
		
	}
	
	public void mostraMenu(){
		
		boolean finalizar = false;
		
		System.out.println("= = = = Bem­vindo(a) ao EconomizaP2 = = = =\n");
		
		while(!finalizar){
			
			int opcao = leInteiro("Digite a opcao desejada:\n1 ­ Cadastrar um Produto\n2 ­ Vender um Produto\n3 ­ Imprimir Balanco\n4 ­ Sair\n\nOpcao:");
		
			switch(opcao){
			
				case 1:
					cadastrarProduto();
					break;
				
				case 2:
					venderProduto();
					break;
					
				case 3:
					imprimirBalanco();
					break;
				case 4:
					finalizar = true;
					break;
				default:
					System.out.println("Opcao invalida! Tente novamente.");
					break;
			
			}
			
		}
		
		input.close();
	}
	
}
