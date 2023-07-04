package lp2.Atividade1;

import java.util.Scanner;

public class tarefa4 {

	public static void main(String[] args) {
		int idade;
		String nome = "";

		Scanner entrada = new Scanner(System.in);
		System.out.print("Qual sua nome e idade? ");
		nome = entrada.nextLine();

		idade = entrada.nextInt();
		int idadeDias = idade * 365;

		System.out.print(nome + " ja viveu " + idadeDias + " dias em sua vida aproximadamente!");

	}
}
