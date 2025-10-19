import java.util.Random;

public class Carro extends Thread {
    private final int id;
    private final Estacionamento estacionamento;
    private final Random random;

    public Carro(int id, Estacionamento estacionamento) {
        this.id = id;
        this.estacionamento = estacionamento;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            estacionamento.entrar(id);
            int tempoEstacionado = 2000 + random.nextInt(3000);
            Thread.sleep(tempoEstacionado);
            estacionamento.sair(id);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Carro " + id + " foi interrompido");
        }
    }
}
