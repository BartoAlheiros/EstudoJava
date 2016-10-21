//Aluno: Jos� Bartolomeu Alheiros Dias Neto
//Int Prog 2. BCC - UFRPE
//Professor: Vanilson Bur�gio


package br.ufrpe.exercicio_array_2.programas;

import java.util.Scanner;

import br.ufrpe.exercicio_array_2.beans.Livro;
import br.ufrpe.exercicio_array_2.repositorios.RepositorioLivros;

public class AplicacaoRepositorioLivros {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String entrada = null;

		//MENU
		RepositorioLivros repo = new RepositorioLivros(); //instanciando um repositorio com os m�todos de CRUD
		String cod;

		do{
			entrada = null; 
			System.out.println("Escolha a opcao desejada: \n\n");
			System.out.println("1 - Cadastrar Livro\n");
			System.out.println("2 - Remover   Livro\n");
			System.out.println("3 - Buscar    Livro\n");
			System.out.println("4 - Alterar   Livro\n");
			System.out.println("5 - Listar   Livros Cadastrados\n");
			System.out.println("6 - Sair\n\n");
			System.out.println("Op��o: "); entrada = input.next(); 
			input.nextLine(); //Limpa o buffer do teclado
			//if(entrada.equals("5")){

			switch(entrada) {

			//instanciando um novo livro, preenchendo e guardando no reposit�rioLivros...  
			case "1":
				Livro liv = new Livro();	
				System.out.println("Digite o nome: \n");
				String t = input.nextLine();
				input.nextLine(); //Limpa o buffer do teclado
				liv.setTitulo(t);


				System.out.println("Qual o Autor?\n");
				String aut = input.nextLine();
				liv.setAutor(aut);
				input.nextLine(); //Limpa o buffer do teclado

				System.out.println("Digite o c�digo do livro: \n");
				cod = input.nextLine();
				input.nextLine(); //Limpa o buffer do teclado
				liv.setCodigo(cod);
				repo.inserir(liv);
				break;

			case "2":
				System.out.println("Digite o c�digo do livro que deseja remover: ");
				cod = input.nextLine();
				repo.remover(cod);
				break;

			case "3":
				System.out.println("Digite o c�digo do livro: ");
				cod = input.nextLine();
				input.nextLine(); //Limpa o buffer do teclado
				liv = repo.buscar(cod);
				if(liv != null) {
					System.out.println(liv);	   
				}else{
					System.out.println("Livro n�o existe!");	   
				}
				break;

			case "4":
				System.out.println("Digite o c�digo do livro que deseja alterar: ");
				cod = input.nextLine();
				repo.alterar(cod);
				break;
			
			case "5":
				repo.listar();
				break;

			default: 
				System.out.println("Digite uma op��o v�lida.");

			}	
			//} //else {

			//} 
		}while(entrada.equals("6") == false);

		System.out.println("Obrigado por utilizar nosso sistema de Livraria!"); 

	}

}
