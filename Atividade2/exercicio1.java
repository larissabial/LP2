package lp2.Atividade2;

import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double f;

        System.out.print("Insira a temperatura em Farenheit: ");
        f = entrada.nextDouble();

        double c =(f-32)*(0.5);

        System.out.print(c);
    }
}
