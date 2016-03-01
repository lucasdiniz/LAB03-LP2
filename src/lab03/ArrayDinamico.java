/* 115111580 - Lucas Diniz dos Santos: LAB 03 - Turma 2 */
package lab03;

public class ArrayDinamico {
	
	private Produto[] estoque;
	private int totalUsado;
	
	public ArrayDinamico(){
		estoque = new Produto[5];
		totalUsado = 0;
	}
	
	public int tamanho(){
		return totalUsado;
	}
	
	public String getInfo(String nome){
		int indice = getIndice(nome);
		return estoque[indice].toString();
	}
	
	private int getIndice(String nome){
		nome = nome.toLowerCase();
		
		for(int i = 0 ; i < totalUsado; i++){
			if(estoque[i].getNome().equalsIgnoreCase(nome)){
				return i;
			}
		}
		return -1; //caso nao exista o produto com esse nome
	}
	
	public int getQuantidade(String nome){
		int indice = getIndice(nome);
		return estoque[indice].getQuantidade();
	}

	private void aumentarArray(){
		Produto[] arrayTemporario = new Produto[2 * totalUsado];
		
		for(int i = 0 ; i < tamanho(); i++){
			arrayTemporario[i] = estoque[i];
		}
		
		estoque = new Produto[2 * totalUsado];
		
		for(int i = 0 ; i < tamanho(); i++){
			estoque[i] = arrayTemporario[i];
		}
	}
	
	public void adcionaElemento(String nome, double preco, String tipo , int quantidadeParaAdcionar){
		
		if(getIndice(nome) != -1){ //Produto ja cadastrado, basta atualizar as informacoes
			int indice = getIndice(nome);
			int quantidadeAnterior = estoque[indice].getQuantidade();
			estoque[indice] = new Produto(nome,tipo,preco,quantidadeAnterior + quantidadeParaAdcionar);
			return;
			
		}
		
		else if(totalUsado >= estoque.length - 1){
			aumentarArray();
		}
		
		estoque[totalUsado] = new Produto(nome,tipo,preco,quantidadeParaAdcionar);
		totalUsado += 1;
	}
	
	public boolean existeElemento(String nome){
		if(getIndice(nome) == -1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void diminuiQuantidade(String nome,int quantidadeParaTirar){
	
		int indice = getIndice(nome);
		int quantidadeAtual = estoque[indice].getQuantidade();
		estoque[indice].setQuantidade(quantidadeAtual - quantidadeParaTirar);
		
	}
	
	public double getPreco(String nome){
	
		int indice = getIndice(nome);
		return estoque[indice].getPreco();
		
	}

	@Override
	public String toString(){
		
		String fatura = "";
		
		double totalPossivel = 0;
		
		for(int i = 0 ; i < tamanho() ; i++){
			fatura += (i + 1) + ") " + estoque[i].toString();
			totalPossivel += estoque[i].getPreco() * estoque[i].getQuantidade();
		}
		
		fatura += "Total que ainda pode ser arrecado: R$ " + totalPossivel + "\n";
		return fatura;
	}

}
