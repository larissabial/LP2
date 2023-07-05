package lp2.Atividade3;

public class Main {
    public static void main(String[] args) {
        Deposito dep = new Deposito();

        Produtor produtor = new Produtor(dep, 1); // Tempo de produção em segundos
        Consumidor consumidor = new Consumidor(dep, 1); // Tempo de consumo em segundos

        produtor.run();
        consumidor.start();
    }
}
