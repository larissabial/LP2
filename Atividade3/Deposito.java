package lp2.Atividade3;

public class Deposito {
	private int contador = 0;

	public synchronized void colocar() {
		try {
			Thread.sleep(100); // Simula um tempo de processamento
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		contador++;
		System.out.println("Produtor: Caixa adicionada. Contador: " + contador);
		notifyAll(); // Notifica todas as threads em espera
	}

	// Implementação Balking
	public synchronized boolean retirar() {
		if (contador > 0) {
			contador--;
			System.out.println("Consumidor (Balking): Caixa retirada. Contador: " + contador);
			return true;
		} else {
			System.out.println("Consumidor (Balking): Não há caixas para retirar.");
			return false;
		}
	}

	// Implementação Guarded Suspension
	public synchronized void retirarGuardedSuspension() {
		while (contador == 0) {
			try {
				wait(); // Aguarda até que haja caixas disponíveis
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		contador--;
		System.out.println("Consumidor (Guarded Suspension): Caixa retirada. Contador: " + contador);
	}

	// Implementação Timed Waits
	public synchronized boolean retirarTimedWaits(long timeout) {
		long endTime = System.currentTimeMillis() + timeout;

		while (contador == 0) {
			long remainingTime = endTime - System.currentTimeMillis();
			if (remainingTime <= 0)
				return false; // Timeout expirado, não há caixas disponíveis

			try {
				wait(remainingTime); // Aguarda até que haja caixas disponíveis ou timeout expire
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		contador--;
		System.out.println("Consumidor (Timed Waits): Caixa retirada. Contador: " + contador);
		return true;
	}
}

