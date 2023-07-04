package lp2.Atividade1;

import java.util.Scanner;

public class tarefa6 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite a largura e altura da parede (em metros): ");
		double largura = entrada.nextDouble();
		double altura = entrada.nextDouble();

		double area = largura * altura;

		double consumo = area * 300;

		double lata = consumo / 2000;

		System.out.print("Vão ser ncessárias " + lata + " latas! ");
	}
}
