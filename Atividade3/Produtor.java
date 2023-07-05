package lp2.Atividade3;

public class Produtor implements Runnable {
    private Deposito dep;
    private int tempoProducao;

    public Produtor(Deposito dep, int tempoProducao) {
        this.dep = dep;
        this.tempoProducao = tempoProducao;
    }

    @Override
    public void run() {
        try {
            while (true) {
                dep.colocar();
                Thread.sleep(tempoProducao * 1000); // Espera o tempo de produção em milissegundos
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

