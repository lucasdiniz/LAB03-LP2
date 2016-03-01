/* 115111580 - Lucas Diniz dos Santos: LAB 03 - Turma 2 */
package lab03;

public class Produto {

	private String nome,tipo;
	private double preco;
	private int quantidade;
	
	public Produto(String nome,String tipo,double preco,int quantidade){
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public String getDadosDoProduto() {
		return this.nome + "(" + this.tipo + "). R$" + this.preco + " Restante: " + this.quantidade + "\n";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Produto){
			Produto produtoAuxiliar = (Produto) obj;
			return produtoAuxiliar.getNome().equalsIgnoreCase(this.nome);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	
}
