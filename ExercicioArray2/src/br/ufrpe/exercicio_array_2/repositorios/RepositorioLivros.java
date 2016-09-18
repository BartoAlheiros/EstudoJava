package br.ufrpe.exercicio_array_2.repositorios;

import java.util.Scanner;

import br.ufrpe.exercicio_array_2.beans.Livro;

public class RepositorioLivros {
	Livro[] livros;
	private int proximo;
	Scanner input = new Scanner(System.in);

	public RepositorioLivros () {
		this.livros = new Livro[100];
		this.proximo = 0;
	}

	public int getProximo () {
		return this.proximo;	   
	}

	//se o codigo j� existir o m�todo printa uma msgem 'N foi poss�vel inserir..' retorna false.
	public boolean inserir (Livro liv) {
		boolean resultado = false;

		if(this.confereCodigo(liv)) {
			System.out.println("Codigo do livro jah existe!");
			return resultado;
		} else{
			this.livros[proximo] = liv;
			this.proximo++;
			resultado = true;
		}

		return resultado;	  
	}

	public Livro buscar (String cod) {
		Livro livro = null;
		for(int i = 0; i < this.getProximo(); i++) {
			if(livros[i].getCodigo().equals(cod)) {
				livro = new Livro();
				livro = this.livros[i];
				break;
			}  
		}
		return livro;
	}

	public void alterar (String cod) {
		Livro liv = new Livro();

		if( (liv = this.buscar(cod)) != null ) {

			System.out.println("Digite o nome: ");
			String t = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			liv.setTitulo(t);

			System.out.println("Qual o Autor?\n");
			String aut = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado
			liv.setAutor(aut);

			System.out.println("Digite o c�digo do livro: \n");
			cod = input.nextLine();
			input.nextLine(); //Limpa o buffer do teclado

		} else {
			System.out.println("Livro n�o existe!");
		}  	  
	}

	public void remover(String cod) {

		for(int i = 0; i < this.getProximo(); i++) {
			if(livros[i].getCodigo().equals(cod)) {
				if(i == proximo - 1){
					livros[i] = null;
					proximo = proximo - 1;
					System.out.println("Livro Removido com Sucesso.");
					break;
				}else {
					livros[i] = livros[proximo - 1];
					livros[proximo -  1] = null;
					proximo = proximo - 1;
					System.out.println("Livro Removido com Sucesso.");
					break;
				}
            }	
		}	  
	}
	
	public void listar( ) {
		if(this.getProximo() > 0){
			for(int i = 0; i < this.getProximo(); i++) {
				System.out.println(livros[i]);
			}
		} else {
			System.out.println("Nenhum livro cadastrado.");
		}
	}

	//passo o livro. Este � um m�todo auxiliar, utilizado pelos m�todos do repositorioLivros, para verificar se o livro que eu quero add, j� tem um c�digo cadastrado no sistema.
	private boolean confereCodigo (Livro liv) {
		boolean resultado = false;
		for(int i = 0; i < this.getProximo(); i++) {
			//se o c�digo do livro[i] for igual ao c�digo do livro que passei, resultado = true.  
			if(livros[i].getCodigo().equals(liv.getCodigo())) {
				resultado = true;	
			}
		}

		return resultado;
	}

}
