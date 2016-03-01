/* 115111580 - Lucas Diniz dos Santos: LAB 03 - Turma 2 */
package lab03;

public class Mercado {
	
	private ArrayDinamico estoque;
	private double totalVendido;
	
	public Mercado(){
		estoque = new ArrayDinamico();
		totalVendido = 0;
	}
	
	public boolean existeProduto(String nome){
		return estoque.existeElemento(nome);
	}
	
	public String informacoesDoProduto(String nome){
		return estoque.getInfo(nome);
	}
	
	public boolean existeSuficiente(String nome,int quantidadeDesejada){
		if(estoque.getQuantidade(nome) < quantidadeDesejada){
			return false;
		}
		else{
			return true;
		}
	}

	public void realizarCadastro(String nome, double preco, String tipo, int quantidade){
		estoque.adcionaElemento(nome,preco,tipo,quantidade);
	}
	
	public double realizarVenda(String nome , int quantidade){	
		estoque.diminuiQuantidade(nome,quantidade);
		double precoDaVenda = estoque.getPreco(nome) * quantidade;
		totalVendido += precoDaVenda;
		return precoDaVenda;
	}
	
	public String balanco(){
		return "= = = = Impressao de Balanco = = = =\n\nProdutos cadastrados:\n"
				+ estoque.toString() +
				"Total arrecado em vendas: R$ " + Double.toString(totalVendido) + "\n";
	}
	

}
