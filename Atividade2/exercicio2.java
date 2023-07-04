package lp2.Atividade2;

import java.util.Scanner;

public class exercicio2 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double p, v, t;

		System.out.print("Insira a pressão do pneu: ");
		p = entrada.nextDouble();

		System.out.print("Insira a volume do pneu: ");
		v = entrada.nextDouble();

		System.out.print("Insira a temperatura do pneu: ");
		t = entrada.nextDouble();

		double d = p * v;

		double m = ((t + 460) / d) / 0.37;

		System.out.print(m);

	}

}
