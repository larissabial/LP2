package lp2.Atividade3;

public class Consumidor extends Thread {
    private Deposito dep;
    private int tempoConsumo;

    public Consumidor(Deposito dep, int tempoConsumo) {
        this.dep = dep;
        this.tempoConsumo = tempoConsumo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                dep.retirar();
                Thread.sleep(tempoConsumo * 1000); // Espera o tempo de consumo em milissegundos
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

