package lp2.Atividade1;

import java.util.Scanner;

public class tarefa5 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite o raio do circulo: ");
		double a = entrada.nextDouble();
		double area = 3.14 * (a * a);

		System.out.print("Área do círculo: " + area);
	}
}
